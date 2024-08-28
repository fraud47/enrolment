package zw.apkmechanik.enrolment.domain.models.users.student;

import zw.co.dreamhub.domain.dto.request.users.UserDetailRequest;
import zw.co.dreamhub.domain.models.enums.Relationship;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Student}
 */
public record StudentRequest(String userId,
                             Set<String> userDeviceTokens,
                             Set<UserDetailRequest> guardianUserDetails,
                             Set<Relationship> guardianRelationships, String gradeId) implements Serializable {
}