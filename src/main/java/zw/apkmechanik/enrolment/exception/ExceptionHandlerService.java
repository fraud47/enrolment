package zw.apkmechanik.enrolment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import zw.apkmechanik.enrolment.domain.dto.response.ApiResponse;
import zw.apkmechanik.enrolment.utils.ResponseUtils;


@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlerService {

    @ExceptionHandler(BaseException.class)
    public final ResponseEntity<ApiResponse<String>> handleException(BaseException exception, WebRequest request) {



        if (exception instanceof AuthException) {
            return new ResponseEntity<>(
                    ResponseUtils.badRequest(exception.getMessage()),
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    ResponseUtils.badRequest(exception.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<String>> handleUnknownException(Exception exception) {

        log.info("Request exception : {}",
                exception.getMessage());

        return new ResponseEntity<>(
                ResponseUtils.badRequest(
                        exception.getMessage()
                ),
                HttpStatus.BAD_REQUEST
        );

    }

}
