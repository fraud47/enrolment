package zw.apkmechanik.enrolment.domain.models.enrollment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.enums.AttendanceStatus;
import zw.co.dreamhub.domain.models.modules.StudentSubject;
import zw.co.dreamhub.domain.models.modules.TeacherSubject;

import java.util.Date;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/08
 */

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentSubject student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherSubject teacher;

    @Column(name = "student_attendance")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus studentAttendance;

    @Column(name = "teacher_attendance")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus teacherAttendance;

    @Column(name = "date")
    private Date date;


}
