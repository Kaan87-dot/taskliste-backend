package de.schule.taskliste;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // sagt Spring: hier stehen Konfigurationseinstellungen
public class WebConfig {

    @Bean // definiert ein Spring-Bean (wird beim Start erstellt und genutzt)
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        // Erlaubt Anfragen auf alle URLs
                        .addMapping("/**")
                        // Erlaubt Zugriffe von allen Domains (Frontend kann Backend ansprechen)
                        .allowedOrigins("*")
                        // Erlaubt nur diese Methoden
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
