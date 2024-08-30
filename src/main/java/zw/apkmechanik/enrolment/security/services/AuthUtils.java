package zw.apkmechanik.enrolment.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import zw.apkmechanik.enrolment.config.env.InfoEnv;
import zw.apkmechanik.enrolment.domain.dto.response.users.AuthResponse;
import zw.apkmechanik.enrolment.domain.models.enums.UserRole;
import zw.apkmechanik.enrolment.domain.models.users.User;
import zw.apkmechanik.enrolment.domain.models.users.common.TokenRefresh;
import zw.apkmechanik.enrolment.domain.repositories.users.TokenRefreshRepository;
import zw.apkmechanik.enrolment.domain.repositories.users.UserRepository;
import zw.apkmechanik.enrolment.security.jwt.JwtUtils;
import zw.apkmechanik.enrolment.utils.StringUtils;
import zw.apkmechanik.enrolment.domain.models.users.common.Role;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class AuthUtils {

    private final UserRepository repository;
    private final TokenRefreshRepository tokenRefreshRepository;
    private final JwtUtils jwtUtils;

    private final InfoEnv env;

    public String getUsername() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }

    public User getUser() {
        return repository.findByUsername(this.getUsername()).get();
    }

    public Boolean isAuthorised(Set<UserRole> roles) {
        Set<UserRole> userRoles = this.getUser().getRoles().stream().map(Role::getType).collect(Collectors.toSet());
        return userRoles.containsAll(roles);
    }

    public AuthResponse authenticate(User user) {

        TokenRefresh refreshToken = new TokenRefresh(user, UUID.randomUUID(),
                ZonedDateTime
                        .now(ZoneId.systemDefault())
                        .plusMinutes(env.security().jwt().jwtRefreshExpirationMs() / 60000)
        );
        tokenRefreshRepository.save(refreshToken);

        return new AuthResponse(
                new AuthResponse.Token(
                        jwtUtils.generateTokenFromUsername(user.getUsername()),
                        env.security().jwt().jwtExpirationMs(),
                        StringUtils.ACCESS_TOKEN_TYPE,
                        refreshToken.getToken().toString(),
                        env.security().jwt().jwtRefreshExpirationMs()
                ),
                user.getRoles().
                        stream()
                        .map(r -> new AuthResponse.Role(r.getType()))
                        .collect(Collectors.toSet())
        );
    }


}
