package zw.apkmechanik.enrolment.domain.mappers.users;

import org.mapstruct.*;
import zw.apkmechanik.enrolment.domain.dto.request.users.UserRequest;
import zw.apkmechanik.enrolment.domain.models.users.User;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserRequest userRequest);

    UserRequest toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRequest userRequest, @MappingTarget User user);
}