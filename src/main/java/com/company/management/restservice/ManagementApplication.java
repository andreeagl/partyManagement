package com.company.management.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.company.management.config", "com.company.management.controllers", "com.company.management.services","com.company.management.repositories"})
@EnableJpaRepositories("com.company.management.repositories")
@EntityScan(basePackages = "com.company.management.entities")
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

}
