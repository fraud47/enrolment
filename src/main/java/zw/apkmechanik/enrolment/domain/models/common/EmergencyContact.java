package zw.apkmechanik.enrolment.domain.models.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;
import zw.apkmechanik.enrolment.domain.models.enums.Relationship;
import zw.apkmechanik.enrolment.domain.models.users.User;
import zw.apkmechanik.enrolment.domain.models.users.common.UserDetail;


@Entity
@Table(name = "emergency_contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContact extends BaseEntity {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "detail_id")
    private UserDetail userDetail;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship",nullable = false)
    private Relationship relationship;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
