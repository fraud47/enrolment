package zw.apkmechanik.enrolment.domain.repositories.users;

import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.users.common.TokenRefresh;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface TokenRefreshRepository extends BaseRepository<TokenRefresh> {

    long deleteAllByIsValidFalse();

    Optional<TokenRefresh> findByTokenAndIsValidTrue(UUID token);

}