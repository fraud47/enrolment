package zw.apkmechanik.enrolment.domain.models.users.student;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    @Mapping(source = "gradeId", target = "grade.id")
    Student toEntity(StudentRequest studentRequest);

    @Mapping(source = "grade.id", target = "gradeId")
    StudentRequest toDto(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student partialUpdate(StudentRequest studentRequest, @MappingTarget Student student);
}