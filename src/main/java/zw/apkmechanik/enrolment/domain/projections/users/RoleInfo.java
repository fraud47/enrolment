package zw.apkmechanik.enrolment.domain.projections.users;


import zw.apkmechanik.enrolment.domain.models.enums.UserRole;

public interface RoleInfo {
    UserRole getType();
}