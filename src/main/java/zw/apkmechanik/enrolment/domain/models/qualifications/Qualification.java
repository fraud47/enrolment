package zw.apkmechanik.enrolment.domain.models.qualifications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.common.Media;
import zw.co.dreamhub.domain.models.users.User;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */

@Entity
@Table(name = "qualification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Qualification extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user; // -> teacher / student

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "qualification_media",
            joinColumns = @JoinColumn(name = "qualification_id"),
            inverseJoinColumns = @JoinColumn(name = "documents_id")
    )
    private Set<Media> documents = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "instudte_id" )
    private Institute institute;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "qualification_type_id")
    private QualificationType type;
}
