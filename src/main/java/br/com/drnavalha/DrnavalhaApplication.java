package br.com.drnavalha;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "br.com.drnavalha")
@EnableMongoRepositories("br.com.drnavalha.repository")
@RestController
public class DrnavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrnavalhaApplication.class, args);
	}

}
