package web4.jobs.utilisateurservice.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Autoriser tous les endpoints
                .allowedOrigins("http://localhost:4200") // Autoriser ton Angular
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
