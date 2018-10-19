package com.Nine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Profile("!test")
public class NineApplication {

	public static void main(String[] args) {
		SpringApplication.run(NineApplication.class, args);
	}
}
