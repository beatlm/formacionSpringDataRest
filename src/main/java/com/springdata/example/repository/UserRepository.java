package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springdata.example.entity.User;


@RepositoryRestResource(collectionResourceRel = "usuarios", path = "user")

public interface UserRepository extends CrudRepository<User, String> {
	@RestResource( rel="obtenerTodos", path="findAll" )//, exported=false)
	public List<User> findAll();
	
	@RestResource( rel="buscarPorNombre", path="findByName" , exported=true)
	public User findByFirstName(@Param("firstName") String firstName);

	 
	public User findOne(@Param("id") String id);
}
