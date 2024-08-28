package zw.apkmechanik.enrolment.domain.repositories.users;

import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.enums.UserRole;
import zw.co.dreamhub.domain.models.users.common.Role;

import java.util.Optional;


@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Optional<Role> findRoleByType(UserRole role);
}