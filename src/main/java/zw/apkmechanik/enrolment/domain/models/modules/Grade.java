package zw.apkmechanik.enrolment.domain.models.modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */
@Entity
@Table(name = "grade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade extends BaseEntity {

    @Column(unique = true)
    private String name;

}
