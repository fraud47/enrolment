package zw.apkmechanik.enrolment.domain.repositories;

import org.springframework.stereotype.Repository;
import zw.co.dreamhub.domain.models.users.student.Student;
import zw.co.dreamhub.domain.repositories.users.BaseRepository;

import java.util.Optional;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/26
 */

@Repository
public interface StudentRepository extends BaseRepository<Student> {
    Optional<Student> findStudentByUser_Id(String userId);
}
