package zw.apkmechanik.enrolment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends BaseException {
    public AuthException(String message) {
        super(message);
    }
}
