package zw.apkmechanik.enrolment.domain.projections.users;

import zw.co.dreamhub.domain.models.enums.UserRole;
import zw.co.dreamhub.domain.models.users.common.Role;

/**
 * Projection for {@link Role}
 */
public interface RoleInfo {
    UserRole getType();
}