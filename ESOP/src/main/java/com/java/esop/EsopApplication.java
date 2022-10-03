package com.java.esop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EsopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsopApplication.class, args);
	}

}
