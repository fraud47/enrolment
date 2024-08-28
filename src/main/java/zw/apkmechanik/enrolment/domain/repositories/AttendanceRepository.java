package zw.apkmechanik.enrolment.domain.repositories;

import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.enrollment.Attendance;
import zw.co.dreamhub.domain.repositories.users.BaseRepository;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/04/04
 */

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance> {
}
