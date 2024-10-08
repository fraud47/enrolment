package zw.apkmechanik.enrolment.domain.dto.request.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import zw.apkmechanik.enrolment.domain.models.enums.Gender;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public record UserDetailRequest(@NotNull @NotBlank String firstName,
                                String middleNames,
                                @NotNull @NotBlank String lastName,
                                @NotNull @Email @NotBlank String email,
                                @NotNull
                                Gender gender,
                                Date dateOfBirth,
                                @NotEmpty Set<@NotNull PhoneNumberRequest> phoneNumbers) implements Serializable {
}