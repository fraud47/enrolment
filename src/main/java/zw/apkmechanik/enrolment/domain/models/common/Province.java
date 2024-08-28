package zw.apkmechanik.enrolment.domain.models.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "province")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Province extends BaseEntity {

    @Column(unique = true)
    private String name;
}
