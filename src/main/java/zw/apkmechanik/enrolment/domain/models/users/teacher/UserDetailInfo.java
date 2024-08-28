package zw.apkmechanik.enrolment.domain.models.users.teacher;

import zw.co.dreamhub.domain.models.enums.Gender;

import java.util.Date;
import java.util.Set;

/**
 * Projection for {@link zw.co.dreamhub.domain.models.users.common.UserDetail}
 */
public interface UserDetailInfo {
    String getFirstName();

    String getMiddleNames();

    String getLastName();

    String getEmail();

    Gender getGender();

    Date getDateOfBirth();

    Set<PhoneNumberInfo> getPhoneNumbers();
}