package com.springdata.example.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.springdata.example.entity.Account;
import com.springdata.example.entity.User;

@Configuration

public class RepositoryConfiguration extends  RepositoryRestConfigurerAdapter {

	@Bean 
	MovementEventHandler movementEventHandler() {
		return new MovementEventHandler();
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(User.class,Account.class);
	}

}
