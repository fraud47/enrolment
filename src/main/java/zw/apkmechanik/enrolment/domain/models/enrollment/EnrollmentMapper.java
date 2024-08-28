package zw.apkmechanik.enrolment.domain.models.enrollment;

import org.mapstruct.*;
import zw.co.dreamhub.domain.dto.request.EnrollmentRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentMapper {
    Enrollment toEntity(EnrollmentRequest enrollmentRequest);

    EnrollmentRequest toDto(Enrollment enrollment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Enrollment partialUpdate(EnrollmentRequest enrollmentRequest, @MappingTarget Enrollment enrollment);
}