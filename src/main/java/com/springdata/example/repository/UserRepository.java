<<<<<<< HEAD
package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springdata.example.entity.User;


@RepositoryRestResource(collectionResourceRel = "usuarios", path = "user")

public interface UserRepository extends CrudRepository<User, String> {
	@RestResource( rel="obtenerTodos", path="findAll" , exported=true)
	public List<User> findAll();
	
	 
	
	@RestResource( rel="buscarPorNombre", path="findByName" , exported=true)
	public User findByFirstName(@Param("firstName") String firstName);
	
	@RestResource( rel="buscarPorApellido", path="findByLastName" , exported=true)
	public User findByLastName(@Param("lastName") String lastName);


}
=======
package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.example.entity.User;



public interface UserRepository extends CrudRepository<User, String> {


	public User findByFirstName(String firstName);
	
	public List<User> findByLastName(String lastName);

	public User findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);
	
	public Long countByFirstName(String firstname);
	
	public String deleteByFirstName(String firstname);

 
	@Query("{'firstName':{$regex:?0,$options:'i'}}")
	public User findByNameIgnoreCase(@Param("firstName") String firstName);
}
>>>>>>> branch 'master' of https://github.com/beatlm/demoSpringData
