package com.school.app.schoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.school.app.schoolapp.config.FileStorageProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({FileStorageProperties.class})
public class SchoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolappApplication.class, args);
	}

}
