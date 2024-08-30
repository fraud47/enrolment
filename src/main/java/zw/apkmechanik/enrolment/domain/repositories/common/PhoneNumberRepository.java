package zw.apkmechanik.enrolment.domain.repositories.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.apkmechanik.enrolment.domain.models.common.PhoneNumber;


@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {
}