package zw.apkmechanik.enrolment.domain.dto.request.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public record UserRequest(
        @NotBlank
        @Email
        String username,
        @NotNull UserDetailRequest detail) implements Serializable {
}