package zw.apkmechanik.enrolment.domain.models.users.teacher;

import zw.co.dreamhub.domain.models.enums.Relationship;
import zw.co.dreamhub.domain.projections.users.UserInfo;

/**
 * Projection for {@link Teacher}
 */
public interface TeacherInfo {
    String getId();

    String getRegistrationNumber();

    EmergencyContactInfo getNextOfKin();

    UserInfo getUser();

    /**
     * Projection for {@link zw.co.dreamhub.domain.models.common.EmergencyContact}
     */
    interface EmergencyContactInfo {
        Relationship getRelationship();

        UserDetailInfo getUserDetail();
    }
}