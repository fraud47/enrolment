package zw.apkmechanik.enrolment.domain.projections.users;


import zw.apkmechanik.enrolment.domain.models.enums.UserStatus;

import java.time.ZonedDateTime;
import java.util.Set;


public interface UserInfo {
    String getId();

    ZonedDateTime getDateCreated();

    ZonedDateTime getLastUpdated();

    String getUsername();



    UserDetailInfo getDetail();

    Set<RoleInfo> getRoles();
}