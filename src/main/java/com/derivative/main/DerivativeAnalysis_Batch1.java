package com.derivative.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = "com") 
public class DerivativeAnalysis_Batch1 {

	public static void main(String[] args) {
		SpringApplication.run(DerivativeAnalysis_Batch1.class, args);
	}

}
