package com.springdata.example.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RepositoryConfiguration {

	@Bean 
	MovementEventHandler movementEventHandler() {
		return new MovementEventHandler();
	}

}
