package zw.apkmechanik.enrolment.domain.dto.request.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link zw.co.dreamhub.domain.models.users.User}
 */
public record UserRequest(
        @NotNull
        String country,
        @NotBlank
        @Email
        String username,
        @NotNull UserDetailRequest detail) implements Serializable {
}