package com.charky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class AthenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenaApplication.class, args);
	}
}

