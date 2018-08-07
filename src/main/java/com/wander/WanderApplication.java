package com.wander;

import com.wander.controller.BadPerson;
import com.wander.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WanderApplication.class, args);
	}
}
