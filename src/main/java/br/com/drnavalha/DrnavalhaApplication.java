package br.com.drnavalha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "br.com.drnavalha")
@EnableMongoRepositories("br.com.drnavalha.repository")
@RestController
public class DrnavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrnavalhaApplication.class, args);
	}

}
