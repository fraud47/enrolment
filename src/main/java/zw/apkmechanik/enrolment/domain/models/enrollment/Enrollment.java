package zw.apkmechanik.enrolment.domain.models.enrollment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.modules.Grade;
import zw.co.dreamhub.domain.models.users.student.Student;

import java.util.Date;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/08
 */

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment extends BaseEntity {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "admission_date")
    private Date admissionDate;

    @OneToOne
    @JoinColumn(name = "level")
    private Grade level;

}
