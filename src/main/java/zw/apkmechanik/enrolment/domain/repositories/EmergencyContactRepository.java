package zw.apkmechanik.enrolment.domain.repositories;

import org.springframework.stereotype.Repository;
import zw.apkmechanik.enrolment.domain.models.common.EmergencyContact;
import zw.apkmechanik.enrolment.domain.repositories.users.BaseRepository;


@Repository
public interface EmergencyContactRepository extends BaseRepository<EmergencyContact> {
}
