package zw.apkmechanik.enrolment.domain.models.users.common;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;
import zw.apkmechanik.enrolment.domain.models.common.PhoneNumber;
import zw.apkmechanik.enrolment.domain.models.enums.Gender;


import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;



    @Column(name = "last_name")
    private String lastName;



    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private Gender gender;
}
