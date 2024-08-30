package zw.apkmechanik.enrolment.domain.models.users.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.apkmechanik.enrolment.domain.models.BaseEntity;
import zw.apkmechanik.enrolment.domain.models.users.User;


import java.time.ZonedDateTime;
import java.util.UUID;


@Entity
@Table(name = "token_refresh")
@Getter
@Setter
@NoArgsConstructor
public class TokenRefresh extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, unique = true, name = "token")
    private UUID token;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", name = "expiry_date")
    private ZonedDateTime expiryDate;

    private Boolean isValid;

    public TokenRefresh(User user, UUID token, ZonedDateTime expiryDate) {
        this.user = user;
        this.token = token;
        this.expiryDate = expiryDate;
        this.isValid = true;
    }

}
