package com.vinegrad.colours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ColourAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColourAppApplication.class, args);
	}

}
