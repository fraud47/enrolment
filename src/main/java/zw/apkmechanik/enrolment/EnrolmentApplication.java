package zw.apkmechanik.enrolment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import zw.apkmechanik.enrolment.config.env.AdminEnv;
import zw.apkmechanik.enrolment.config.env.EmailEnv;
import zw.apkmechanik.enrolment.config.env.InfoEnv;

@SpringBootApplication
@EnableConfigurationProperties({AdminEnv.class, InfoEnv.class})

public class EnrolmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrolmentApplication.class, args);
	}

}
