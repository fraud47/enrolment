package zw.apkmechanik.enrolment.domain.dto.response.users;



import zw.apkmechanik.enrolment.domain.models.enums.UserRole;

import java.util.Set;


public record AuthResponse(
        Token token, Set<Role> roles
) {

    public record Token(String access, long expiresIn,
                        String accessTokenType,
                        String refresh, long refreshExpiresIn) {
    }

    public record Role(UserRole type) {
    }


}
