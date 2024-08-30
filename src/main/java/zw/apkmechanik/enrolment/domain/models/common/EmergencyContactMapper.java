package zw.apkmechanik.enrolment.domain.models.common;

import org.mapstruct.*;
import zw.apkmechanik.enrolment.domain.dto.request.EmergencyContactRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmergencyContactMapper {
    EmergencyContact toEntity(EmergencyContactRequest emergencyContactRequest);

    EmergencyContactRequest toDto(EmergencyContact emergencyContact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EmergencyContact partialUpdate(EmergencyContactRequest emergencyContactRequest, @MappingTarget EmergencyContact emergencyContact);
}