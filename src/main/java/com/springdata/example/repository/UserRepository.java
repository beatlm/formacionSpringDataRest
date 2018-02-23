package com.springdata.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springdata.example.entity.User;
import com.springdata.example.entity.UserInfo;


//@RepositoryRestResource(excerptProjection = UserInfo.class)
public interface UserRepository extends CrudRepository<User, String> {
	
	public List<User> findAllByOrderByFirstNameAsc();

	public List<User> findAllByOrderByFirstNameDesc();
	
	public List<User> findAllByOrderByAgeAsc();

	public User findByFirstName(@Param("firstName") String firstName);

	public List<User> findByLastName(@Param("lastName")String lastName);

	public User findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);

	public Long countByFirstName(@Param("firstName")String firstname);

	public String deleteByFirstName(@Param("firstName")String firstname);


	@Query("{'firstName':{$regex:?0,$options:'i'}}")
	public User findByNameIgnoreCase(@Param("firstName") String firstName);
}
