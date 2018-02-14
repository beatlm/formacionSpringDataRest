package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springdata.example.entity.User;
import com.springdata.example.projection.FullName;


@RepositoryRestResource(excerptProjection = FullName.class)
public interface UserRepository extends CrudRepository<User, String> {


	public User findByFirstName(String firstName);
	
	public List<User> findByLastName(String lastName);

	public User findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);
	
	public Long countByFirstName(String firstname);
	
	public String deleteByFirstName(String firstname);

 
	@Query("{'firstName':{$regex:?0,$options:'i'}}")
	public User findByNameIgnoreCase(@Param("firstName") String firstName);
}

