package com.ecommerce.productManagementTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(basePackages = {"controller" , "service"})
public class ProductManagementToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementToolApplication.class, args);
	}

}
