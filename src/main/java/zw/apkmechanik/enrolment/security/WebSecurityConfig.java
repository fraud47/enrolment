package zw.apkmechanik.enrolment.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import zw.apkmechanik.enrolment.config.env.InfoEnv;
import zw.apkmechanik.enrolment.security.jwt.AuthEntryPointJwt;
import zw.apkmechanik.enrolment.security.jwt.AuthTokenFilter;


@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthenticationProvider authenticationProvider;
    private final AuthTokenFilter authenticationJwtTokenFilter;

    private final InfoEnv env;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, env.url().unSecured() + "/default").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exp -> exp.authenticationEntryPoint(unauthorizedHandler))

                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)

                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        String publicUrlPrefix = env.url().unSecured() + "/**";

        return web -> {
            web.ignoring().requestMatchers(
                    HttpMethod.POST,
                    publicUrlPrefix
            );
            web.ignoring().requestMatchers(
                    HttpMethod.GET,
                    publicUrlPrefix
            );
            web.ignoring().requestMatchers(
                    HttpMethod.DELETE,
                    publicUrlPrefix
            );
            web.ignoring().requestMatchers(
                    HttpMethod.PUT,
                    publicUrlPrefix
            );
            web.ignoring().requestMatchers(
                            HttpMethod.OPTIONS,
                            publicUrlPrefix
                    )
                    .requestMatchers("/v3/api-docs/**", "/configuration/**", "/swagger-ui/**",
                            "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**", "/error", "/actuator/**");

        };
    }


}
