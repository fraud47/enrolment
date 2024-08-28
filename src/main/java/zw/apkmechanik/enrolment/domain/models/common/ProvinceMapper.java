package zw.apkmechanik.enrolment.domain.models.common;

import org.mapstruct.*;
import zw.co.dreamhub.domain.dto.request.ProvinceRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProvinceMapper {
    Province toEntity(ProvinceRequest provinceRequest);

    ProvinceRequest toDto(Province province);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Province partialUpdate(ProvinceRequest provinceRequest, @MappingTarget Province province);
}