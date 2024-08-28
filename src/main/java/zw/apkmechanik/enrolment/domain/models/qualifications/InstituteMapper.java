package zw.apkmechanik.enrolment.domain.models.qualifications;

import org.mapstruct.*;
import zw.co.dreamhub.domain.dto.request.InstituteRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InstituteMapper {
    Institute toEntity(InstituteRequest instituteRequest);

    InstituteRequest toDto(Institute institute);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Institute partialUpdate(InstituteRequest instituteRequest, @MappingTarget Institute institute);
}