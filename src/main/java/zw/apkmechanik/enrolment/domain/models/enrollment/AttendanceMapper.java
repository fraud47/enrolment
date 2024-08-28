package zw.apkmechanik.enrolment.domain.models.enrollment;

import org.mapstruct.*;
import zw.co.dreamhub.domain.dto.request.AttendanceRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttendanceMapper {
    Attendance toEntity(AttendanceRequest attendanceRequest);

    AttendanceRequest toDto(Attendance attendance);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Attendance partialUpdate(AttendanceRequest attendanceRequest, @MappingTarget Attendance attendance);
}