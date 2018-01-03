package com.springdata.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springdata.example.entity.Account;


/*
 * At runtime, Spring Data REST will create an implementation of this interface automatically. 
 * Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at /users.
 * 
 * collectionResourceRel
 * The rel value to use when generating links to the collection resource.
 * */
@RepositoryRestResource(collectionResourceRel = "accounts", path = "account")
	
	public interface AccountRepository extends MongoRepository<Account, String> {

	//	List<User> findByLastName(@Param("name") String name);

	}
