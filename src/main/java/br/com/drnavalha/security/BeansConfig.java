package br.com.drnavalha.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.web.cors.CorsConfiguration.ALL;

@Configuration
public class BeansConfig {

    @Value("${config.uris.angular-uri}")
    private String ANGULAR_URI;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public String toString() {
        return new String();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource( ){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        cors.setAllowCredentials(true);
<<<<<<< HEAD
        cors.addAllowedOrigin(ALL);
=======
        cors.addAllowedOrigin(ANGULAR_URI);
        cors.addAllowedOrigin("http://localhost:4200");
>>>>>>> d96c4a08fbb47d49a4d9dc59b96922baeb355310
        source.registerCorsConfiguration("/**", cors);

        return source;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

