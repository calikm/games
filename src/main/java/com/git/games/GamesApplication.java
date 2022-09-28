package com.git.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

}
//here you will find 2 data access service classes, one for embedded db and one for external - i left the embedded methods in the external one
//in case i want to come back to it and easily compare/change it - most of them can be removed as currently, only post mapping is implemented