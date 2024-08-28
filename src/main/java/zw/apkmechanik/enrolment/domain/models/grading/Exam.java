package zw.apkmechanik.enrolment.domain.models.grading;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.modules.TeacherSubject;
import zw.co.dreamhub.domain.models.semester.Semester;
import zw.co.dreamhub.domain.models.users.student.Student;

import java.time.ZonedDateTime;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */
public class Exam extends BaseEntity {
    @Column(name = "name",unique = true)
    private String name;
    private String description;
    @Column(name = "exam_date")
    private ZonedDateTime date;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "mark")
    private Double mark;
    private Grading grading;
    private TeacherSubject subject;
    private Semester semester;
}
