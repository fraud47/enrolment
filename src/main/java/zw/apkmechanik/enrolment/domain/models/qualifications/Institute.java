package zw.apkmechanik.enrolment.domain.models.qualifications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.common.Province;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */

@Entity
@Table(name = "institute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Institute extends BaseEntity {

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}
