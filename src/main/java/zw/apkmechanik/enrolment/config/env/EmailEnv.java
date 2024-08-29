package zw.co.dreamhub.config.env;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring")
public record EmailEnv(
        Mail mail
) {

    public record Mail(
            String host,
            int port,
            String username,
            String password
    ) {
    }
}
