package zw.apkmechanik.enrolment.domain.models.semester;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;

import java.time.Year;
import java.util.Date;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */

@Entity
@Table(name = "semester")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semester extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "type_id")
    private SemesterType type;

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private Year year;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;
}
