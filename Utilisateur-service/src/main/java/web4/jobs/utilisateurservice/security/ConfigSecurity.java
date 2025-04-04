package web4.jobs.utilisateurservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(h -> h.frameOptions(fo -> fo.disable()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(api -> api.requestMatchers("/api/**", "/h2-console/**").permitAll())
                .authorizeHttpRequests(api -> api.anyRequest().authenticated())
                .build();
    }
}