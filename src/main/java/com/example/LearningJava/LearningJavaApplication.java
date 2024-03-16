package com.example.LearningJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class LearningJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningJavaApplication.class, args);
	}

}
