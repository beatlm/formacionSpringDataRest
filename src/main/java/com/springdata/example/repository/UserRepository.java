package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.example.entity.User;



public interface UserRepository extends CrudRepository<User, String> {

//	public List<User> findAll();
	
//	public User findByFirstName(@Param("firstName") String firstName);

	 
}
