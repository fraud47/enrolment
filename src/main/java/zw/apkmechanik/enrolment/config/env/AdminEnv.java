package zw.co.dreamhub.config.env;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "admin-details")
public record AdminEnv(
        String username,
        String password,
        String phoneNumber

) {
}
