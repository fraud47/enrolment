package zw.apkmechanik.enrolment.domain.models.users.teacher;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeacherMapper {
    Teacher toEntity(TeacherRequest teacherRequest);

    TeacherRequest toDto(Teacher teacher);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Teacher partialUpdate(TeacherRequest teacherRequest, @MappingTarget Teacher teacher);
}