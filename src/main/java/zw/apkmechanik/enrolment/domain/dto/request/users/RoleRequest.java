package zw.apkmechanik.enrolment.domain.dto.request.users;

import jakarta.validation.constraints.NotNull;
import zw.apkmechanik.enrolment.domain.models.enums.UserRole;


import java.io.Serializable;

public record RoleRequest(@NotNull UserRole type) implements Serializable {
}