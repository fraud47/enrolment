package zw.apkmechanik.enrolment.domain.repositories.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.common.Province;
import zw.co.dreamhub.domain.models.common.ProvinceInfo;
import zw.co.dreamhub.domain.repositories.users.BaseRepository;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/30
 */
@Repository
public interface ProvinceRepository extends BaseRepository<Province> {
    @Query(value = "SELECT p FROM Province p", nativeQuery = true)
    Page<ProvinceInfo> findAllProvinces(Pageable pageable);
}
