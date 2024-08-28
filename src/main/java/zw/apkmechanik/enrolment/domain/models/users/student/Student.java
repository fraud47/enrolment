package zw.apkmechanik.enrolment.domain.models.users.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.modules.Grade;
import zw.co.dreamhub.domain.models.users.User;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/08
 */

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

    @Column(name = "registration_registration", unique = true, nullable = false)
    private String registrationNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Student(User user){
        this.user = user;
    }

}
