package zw.apkmechanik.enrolment.domain.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zw.apkmechanik.enrolment.domain.models.users.teacher.Teacher;
import zw.apkmechanik.enrolment.domain.models.users.teacher.TeacherInfo;
import zw.apkmechanik.enrolment.domain.repositories.users.BaseRepository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher> {
    Optional<Teacher> findTeacherByUser_Id(String userId);

    @Query(value = "SELECT t FROM Teacher t", nativeQuery = true)
    Page<TeacherInfo> findAllTeachers(Pageable pageable);


    Page<TeacherInfo> findTeachersByIdNotNull(Pageable pageable);

}
