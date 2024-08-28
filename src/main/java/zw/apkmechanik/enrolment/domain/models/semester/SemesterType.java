package zw.apkmechanik.enrolment.domain.models.semester;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.school.School;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */

@Entity
@Table(name = "semester_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterType extends BaseEntity {

    @Column(name = "count")
    private Long count;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;
}
