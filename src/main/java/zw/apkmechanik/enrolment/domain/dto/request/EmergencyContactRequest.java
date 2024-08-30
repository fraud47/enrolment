package zw.apkmechanik.enrolment.domain.dto.request;


import zw.apkmechanik.enrolment.domain.dto.request.users.UserDetailRequest;
import zw.apkmechanik.enrolment.domain.models.enums.Relationship;

import java.io.Serializable;


public record EmergencyContactRequest(UserDetailRequest userDetail,
                                      Relationship relationship,
                                      String userId) implements Serializable {
}