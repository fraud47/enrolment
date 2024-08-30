package zw.apkmechanik.enrolment.services.users;

import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zw.apkmechanik.enrolment.config.env.InfoEnv;
import zw.apkmechanik.enrolment.domain.dto.request.users.*;
import zw.apkmechanik.enrolment.domain.dto.response.ApiResponse;
import zw.apkmechanik.enrolment.domain.dto.response.PaginatedResponse;
import zw.apkmechanik.enrolment.domain.mappers.users.UserMapper;
import zw.apkmechanik.enrolment.domain.models.enums.UserRole;
import zw.apkmechanik.enrolment.domain.models.enums.UserStatus;
import zw.apkmechanik.enrolment.domain.models.users.User;
import zw.apkmechanik.enrolment.domain.models.users.common.Role;
import zw.apkmechanik.enrolment.domain.models.users.common.TokenRefresh;
import zw.apkmechanik.enrolment.domain.projections.users.UserInfo;
import zw.apkmechanik.enrolment.domain.repositories.users.TokenRefreshRepository;
import zw.apkmechanik.enrolment.domain.repositories.users.UserRepository;
import zw.apkmechanik.enrolment.exception.AlreadyExistException;
import zw.apkmechanik.enrolment.exception.AuthException;
import zw.apkmechanik.enrolment.exception.NotFoundException;
import zw.apkmechanik.enrolment.security.services.AuthUtils;
import zw.apkmechanik.enrolment.security.services.PasswordService;
import zw.apkmechanik.enrolment.utils.RegistrationUtils;
import zw.apkmechanik.enrolment.utils.ResponseUtils;
import zw.apkmechanik.enrolment.utils.StringUtils;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenRefreshRepository tokenRefreshRepository;
    private final AuthUtils authUtils;
    private final InfoEnv env;
    private final PasswordService passwordService;

    private final UserMapper userMapper;
    private final RegistrationUtils utils;
    private final PasswordEncoder encoder;

    private static final String NAME = "User";
    private String password = null;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    @Transactional
    public ApiResponse<String> register(UserRequest request, UserRole role) {
        Optional<User> user = userRepository.findByUsername(request.username());
        if (user.isPresent()) {
            throw new AlreadyExistException(StringUtils.alreadyExists(NAME));
        } else {
            password = passwordService.randomPassword();
            User regUser = userMapper.toEntity(request);
            regUser.setRoles(Collections.singleton( new Role(role)));
            regUser.setPassword(encoder.encode(password));
            regUser.setStatus(UserStatus.ACTIVE);
            System.out.println(password);
            userRepository.save(regUser);


            String username = request.username();
            String content = String.format(StringUtils.EMAIL_MESSAGE, username, password);
            return ResponseUtils.created(StringUtils.SUCCESS);
        }
    }

    public ApiResponse<Object> login(UserLoginRequest request) {
        Optional<User> user = userRepository.findByUsername(request.username());

        if (user.isPresent()) {
            if (user.get().getStatus().equals(UserStatus.ACTIVE)) {
                if (encoder.matches(request.password(), user.get().getPassword())) {
                    // persist notification token if it's available
                    if(request.deviceToken() != null){
                        user.get().getDeviceTokens().add(request.deviceToken());
                        userRepository.save(user.get());
                    }
                    // respond
                    return ResponseUtils.success(authUtils.authenticate(user.get()));
                } else {
                    throw new AuthException("Bad credentials");
                }
            } else {
                throw new AuthException("Account locked");
            }
        } else {
            throw new AuthException(StringUtils.notFound(NAME));
        }
    }

    public ApiResponse<Object> refreshToken(RefreshTokenRequest request) {
        Optional<TokenRefresh> tokenRefresh = tokenRefreshRepository.findByTokenAndIsValidTrue(request.token());
        if (tokenRefresh.isPresent()) {
            ZonedDateTime now = ZonedDateTime
                    .now(ZoneId.systemDefault());

            if (tokenRefresh.get().getExpiryDate().isBefore(now) || tokenRefresh.get().getExpiryDate().isEqual(now)) {
                tokenRefresh.get().setIsValid(false);
                tokenRefreshRepository.save(tokenRefresh.get());
                return ResponseUtils.success(tokenRefresh.get().getUser());
            } else {
                throw new ValidationException("Token expired");
            }
        } else {
            throw new NotFoundException(StringUtils.notFound("Token"));
        }

    }

    public ApiResponse<Object> getUser(String username) {
        Optional<UserInfo> user = userRepository.findByUsernameIgnoreCase(username);
        if (user.isPresent()) {
            return ResponseUtils.success(
                    user.get()
            );
        } else {
            throw new NotFoundException(StringUtils.notFound(NAME));
        }
    }

    public ApiResponse<String> changePassword(ChangePasswordRequest request) {
        Optional<User> user = userRepository.findByUsername(authUtils.getUsername());
        return user.map(u -> {
            if (request.newPassword().equals(request.oldPassword())) {
                throw new ValidationException(StringUtils.SAME_PASSWORD);
            } else {
                if (request.newPassword().equals(request.confirmPassword())) {
                    u.setPassword(encoder.encode(request.newPassword()));
                    userRepository.save(u);
                    return ResponseUtils.success(
                            StringUtils.SUCCESS
                    );
                } else {
                    throw new ValidationException(StringUtils.DIFFERENT_PASSWORDS);
                }
            }
        }).orElseThrow(() ->
                new NotFoundException(StringUtils.notFound(NAME))
        );

    }

    public ApiResponse<String> resetPassword(ResetPasswordRequest request) {
        Optional<User> user = userRepository.findByUsername(request.username());
        return user.map(u -> {
                    String password = passwordService.randomPassword();
                    u.setPassword(encoder.encode(password));
                    userRepository.save(u);

                    return ResponseUtils.success(
                            StringUtils.SUCCESS
                    );
                })
                .orElseThrow(() -> new NotFoundException(StringUtils.notFound(NAME)));
    }

    public ApiResponse<PaginatedResponse<UserInfo>> getUsersByRole(
            UserRole role,
            int pageNumber,
            int pageCount
    ) {
        Page<UserInfo> data = userRepository.findByRoles_TypeOrderByUsername(role, PageRequest.of(pageNumber, pageCount));

        return ResponseUtils.success(
                ResponseUtils.pageResponse(data, pageNumber)
        );
    }

    public ApiResponse<String> updateUserDetail(String userId, UserRequest request) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(u -> {
            userMapper.partialUpdate(request,u);
            userRepository.save(u);
            return ResponseUtils.success(
                    StringUtils.SUCCESS
            );
        }).orElseThrow(() -> new NotFoundException(StringUtils.notFound(NAME)));
    }

    public ApiResponse<String> deleteUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(u -> {
            userRepository.delete(u);
            return ResponseUtils.success(
                    StringUtils.DELETED
            );
        }).orElseThrow(() -> new NotFoundException(StringUtils.notFound(NAME)));
    }

}
