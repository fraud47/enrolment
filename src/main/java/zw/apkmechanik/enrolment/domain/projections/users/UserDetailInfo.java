package zw.apkmechanik.enrolment.domain.projections.users;


import java.time.ZonedDateTime;
import java.util.Set;


public interface UserDetailInfo {
    ZonedDateTime getDateCreated();

    ZonedDateTime getLastUpdated();

    String getFirstName();


    String getLastName();

    String getEmail();

    Set<PhoneNumberInfo> getPhoneNumbers();
}