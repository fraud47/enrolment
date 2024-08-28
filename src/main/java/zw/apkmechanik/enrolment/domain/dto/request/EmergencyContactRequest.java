package zw.apkmechanik.enrolment.domain.dto.request;

import zw.co.dreamhub.domain.dto.request.users.UserDetailRequest;
import zw.co.dreamhub.domain.models.common.EmergencyContact;
import zw.co.dreamhub.domain.models.enums.Relationship;

import java.io.Serializable;

/**
 * DTO for {@link EmergencyContact}
 */
public record EmergencyContactRequest(UserDetailRequest userDetail,
                                      Relationship relationship,
                                      String userId) implements Serializable {
}