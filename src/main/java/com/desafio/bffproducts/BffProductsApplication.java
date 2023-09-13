package com.desafio.bffproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableFeignClients
public class BffProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffProductsApplication.class, args);
	}

}
