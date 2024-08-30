package zw.apkmechanik.enrolment.domain.repositories.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zw.apkmechanik.enrolment.domain.models.common.Province;
import zw.apkmechanik.enrolment.domain.models.common.ProvinceInfo;
import zw.apkmechanik.enrolment.domain.repositories.users.BaseRepository;

@Repository
public interface ProvinceRepository extends BaseRepository<Province> {
    @Query(value = "SELECT p FROM Province p", nativeQuery = true)
    Page<ProvinceInfo> findAllProvinces(Pageable pageable);
}
