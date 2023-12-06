package com.example.azureblob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
public class AzureBlobApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureBlobApplication.class, args);
	}

}
