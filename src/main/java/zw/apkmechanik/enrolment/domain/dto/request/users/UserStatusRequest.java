package zw.apkmechanik.enrolment.domain.dto.request.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import zw.apkmechanik.enrolment.domain.models.enums.UserStatus;

public record UserStatusRequest(

        @NotNull
        @NotBlank
        @Email
        String username,

        @NotNull
        UserStatus status
) {
}
