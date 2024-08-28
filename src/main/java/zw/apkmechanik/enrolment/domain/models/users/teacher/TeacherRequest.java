package zw.apkmechanik.enrolment.domain.models.users.teacher;

import zw.co.dreamhub.domain.dto.request.users.UserDetailRequest;
import zw.co.dreamhub.domain.models.enums.Relationship;

import java.io.Serializable;

/**
 * DTO for {@link Teacher}
 */
public record TeacherRequest(String userId,
                             UserDetailRequest nextOfKinUserDetail,
                             Relationship nextOfKinRelationship) implements Serializable {
}