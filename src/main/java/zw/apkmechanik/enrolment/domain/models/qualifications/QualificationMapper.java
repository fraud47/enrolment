package zw.apkmechanik.enrolment.domain.models.qualifications;

import org.mapstruct.*;
import zw.co.dreamhub.domain.dto.request.QualificationRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QualificationMapper {
    Qualification toEntity(QualificationRequest qualificationRequest);

    QualificationRequest toDto(Qualification qualification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Qualification partialUpdate(QualificationRequest qualificationRequest, @MappingTarget Qualification qualification);
}