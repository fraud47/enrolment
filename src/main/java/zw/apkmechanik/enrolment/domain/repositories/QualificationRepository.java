package zw.apkmechanik.enrolment.domain.repositories;

import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.qualifications.Qualification;
import zw.co.dreamhub.domain.repositories.users.BaseRepository;

import java.util.Optional;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/30
 */

@Repository
public interface QualificationRepository extends BaseRepository<Qualification> {
    Optional<Qualification> findByUser_Id(String userId);
}
