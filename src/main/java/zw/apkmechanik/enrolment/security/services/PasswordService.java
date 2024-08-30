package zw.apkmechanik.enrolment.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import zw.apkmechanik.enrolment.config.env.InfoEnv;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class PasswordService {

    final InfoEnv env;

    @Bean
    public String randomPassword() {

        StringBuilder salt = new StringBuilder();
        Random random = new Random();

        while (salt.length() < 6) {
            salt.append(env.security()
                    .password()
                    .saltChars()
                    .toLowerCase()
                    .charAt(random
                            .nextInt(env.security()
                                    .password()
                                    .saltChars()
                                    .length())));
        }

        return salt.toString();

    }

}
