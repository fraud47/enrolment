package zw.apkmechanik.enrolment.domain.repositories.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.enums.UserRole;
import zw.co.dreamhub.domain.models.users.User;
import zw.co.dreamhub.domain.projections.users.UserInfo;

import java.util.Optional;


@Repository
public interface UserRepository extends BaseRepository<User>{
    Optional<User> findByUsername(String username);

    Page<UserInfo> findByRoles_TypeOrderByUsername(UserRole type, Pageable pageable);

    Optional<UserInfo> findByUsernameIgnoreCase(String username);
}