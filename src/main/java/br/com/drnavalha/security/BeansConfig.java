package br.com.drnavalha.security;

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
        cors.addAllowedOrigin(ALL);
        source.registerCorsConfiguration("/**", cors);

        return source;
    }

//    @Bean
//    public OAuth2User oauth2User() {
//        Map<String, Object> attributes = Collections.singletonMap("email", "user@example.com");
//        OAuth2User user = new DefaultOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority("CLIENT")), // Authorities
//                attributes, // Attributes
//                "email"
//        );
//
//        return user;
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

