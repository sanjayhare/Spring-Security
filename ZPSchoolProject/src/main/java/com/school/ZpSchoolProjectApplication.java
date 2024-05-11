package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ZpSchoolProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZpSchoolProjectApplication.class, args);
	}

}
