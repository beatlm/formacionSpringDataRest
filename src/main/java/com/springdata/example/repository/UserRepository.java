package com.springdata.example.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.example.entity.User;



public interface UserRepository extends CrudRepository<User, String> {


	public User findByFirstName(@Param("firstName") String firstName);

	public User findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);

 
	@Query("{'firstName':{$regex:?0,$options:'i'}}")
	public User findByNameIgnoreCase(@Param("firstName") String firstName);
}
