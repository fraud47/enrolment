package zw.apkmechanik.enrolment.domain.models.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;


@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    @Column(name = "surbub")
    private String surbub;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
