package zw.apkmechanik.enrolment.security.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import zw.apkmechanik.enrolment.config.env.InfoEnv;
import zw.apkmechanik.enrolment.security.services.UserDetailsImpl;


import java.time.Instant;
import java.util.Date;



@Component
@Slf4j
@RequiredArgsConstructor
public class JwtUtils {

    private final InfoEnv env;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusMillis(env.security().jwt().jwtExpirationMs())))
                .signWith(SignatureAlgorithm.HS512, env.security().jwt().secret())
                .compact();
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder().
                setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusMillis(env.security().jwt().jwtExpirationMs())))
                .signWith(SignatureAlgorithm.HS512, env.security().jwt().secret())
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(env.security().jwt().secret()).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(env.security().jwt().secret()).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token : {}", (Object) e.getStackTrace());
        } catch (ExpiredJwtException e) {
            log.info("JWT token is expired : {}", (Object) e.getStackTrace());
        } catch (UnsupportedJwtException e) {
            log.info("JWT token is unsupported : {}", (Object) e.getStackTrace());
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty : {}", (Object) e.getStackTrace());
        }

        return false;
    }

}
