package zw.apkmechanik.enrolment.domain.models.common;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity {

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String code;
}
