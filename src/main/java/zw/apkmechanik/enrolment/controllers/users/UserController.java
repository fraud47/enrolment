package zw.apkmechanik.enrolment.controllers.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.apkmechanik.enrolment.domain.dto.request.users.*;
import zw.apkmechanik.enrolment.domain.dto.response.ApiResponse;
import zw.apkmechanik.enrolment.domain.dto.response.PaginatedResponse;
import zw.apkmechanik.enrolment.domain.models.enums.UserRole;
import zw.apkmechanik.enrolment.domain.projections.users.UserInfo;
import zw.apkmechanik.enrolment.services.users.UserService;
import zw.apkmechanik.enrolment.utils.ResponseUtils;


@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "user & auth management")
public class UserController {

    private final UserService service;





    @PostMapping(value = "${info.url.unSecured}/users/register/user", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register User", description = "Registers users")
    public ResponseEntity<ApiResponse<String>> registerUser(@Valid @RequestBody UserRequest request,
                                                            @RequestParam(name = "role") UserRole role) {

            var response = service.register(request, role);
            return ResponseUtils.respond(response);

    }

    @PostMapping(value = "${info.url.unSecured}/users/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Login", description = "Authenticates users")
    public ResponseEntity<ApiResponse<Object>> login(@Valid @RequestBody UserLoginRequest request) {
        var response = service.login(request);
        return ResponseUtils.respond(response);
    }

    @PostMapping(value = "${info.url.unSecured}/users/refresh", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Refresh Token", description = "Refreshes auth session")
    public ResponseEntity<ApiResponse<Object>> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        var response = service.refreshToken(request);
        return ResponseUtils.respond(response);
    }

    @GetMapping(value = "${info.url.secured}/user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "User Details", description = "Gets authenticated user details")
    public ResponseEntity<ApiResponse<Object>> getUser(@RequestParam(name = "username") @Email String username) {
        var response = service.getUser(username);
        return ResponseUtils.respond(response);
    }

    @GetMapping(value = "${info.url.secured}/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Users", description = "Gets all users by role")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public ResponseEntity<ApiResponse<PaginatedResponse<UserInfo>>> getUsersByRole(
            @RequestParam(name = "type") UserRole role,
            @RequestParam(name = "pageNumber") int pageNumber,
            @RequestParam(name = "pageCount") int pageCount
    ) {
        var response = service.getUsersByRole(role, pageNumber, pageCount);
        return ResponseUtils.respond(response);
    }

    @PutMapping(value = "${info.url.secured}/users/change-password", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Change password", description = "Change user password")
    public ResponseEntity<ApiResponse<String>> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        var response = service.changePassword(request);
        return ResponseUtils.respond(response);
    }

    @PostMapping(value = "${info.url.unSecured}/users/reset-password", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Reset Password", description = "Reset user password")
    public ResponseEntity<ApiResponse<String>> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        var response = service.resetPassword(request);
        return ResponseUtils.respond(response);
    }

    @PutMapping(value = "${info.url.secured}/users/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @Operation(summary = "Update User Info", description = "Update User Info")
    public ResponseEntity<ApiResponse<String>> updateUserDetails(@PathVariable String id,
                                                                 @Valid @RequestBody UserRequest request) {
        var response = service.updateUserDetail(id,request);
        return ResponseUtils.respond(response);
    }
    @DeleteMapping(value = "${info.url.secured}/users/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @Operation(summary = "Delete User", description = "Delete a user by ID")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable String id) {
        var response = service.deleteUser(id);
        return ResponseUtils.respond(response);
    }
}
