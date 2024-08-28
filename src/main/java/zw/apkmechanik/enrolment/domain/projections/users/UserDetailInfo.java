package zw.apkmechanik.enrolment.domain.projections.users;

import zw.co.dreamhub.domain.models.users.common.UserDetail;

import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Projection for {@link UserDetail}
 */
public interface UserDetailInfo {
    ZonedDateTime getDateCreated();

    ZonedDateTime getLastUpdated();

    String getFirstName();

    String getMiddleNames();

    String getLastName();

    String getEmail();

    Set<PhoneNumberInfo> getPhoneNumbers();
}