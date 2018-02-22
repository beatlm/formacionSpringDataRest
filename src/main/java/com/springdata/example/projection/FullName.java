package com.springdata.example.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.springdata.example.entity.User;



@Projection (name = "virtual", types = {User.class})

public interface FullName{
	@Value("#{target.firstName} #{target.lastName}")
	String getFullName();
	
	@Value("#{2018-target.age}")
	String getBirthYear();
	
	String getAge();

}


