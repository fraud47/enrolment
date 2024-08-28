package zw.apkmechanik.enrolment.domain.models.school;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.common.Address;
import zw.co.dreamhub.domain.models.common.Province;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */
@Entity
@Table(name = "school")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Contact> contacts = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "average_enrollment")
    private Long averageEnrollment;

}
