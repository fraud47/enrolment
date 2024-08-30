package zw.apkmechanik.enrolment.domain.models.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;
import zw.apkmechanik.enrolment.domain.models.enums.UserStatus;
import zw.apkmechanik.enrolment.domain.models.users.common.Role;
import zw.apkmechanik.enrolment.domain.models.users.common.UserDetail;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status = UserStatus.ACTIVE;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "detail_id")
    private UserDetail detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles"
//                        ,joinColumns = {@JoinColumn(name = "users_id"), @JoinColumn(name = "roles_id")}
    )
    private Set<Role> roles = new HashSet<>(Collections.emptySet());

    @ElementCollection
    @CollectionTable(name = "device_tokens", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "device_tokens", columnDefinition = "TEXT")
    @Fetch(FetchMode.JOIN)
    private Set<String> deviceTokens = new HashSet<>(Collections.emptySet());

}
