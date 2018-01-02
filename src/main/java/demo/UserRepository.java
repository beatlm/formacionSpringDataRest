package demo;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/*
 * At runtime, Spring Data REST will create an implementation of this interface automatically. 
 * Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at /users.
 * 
 * collectionResourceRel
 * The rel value to use when generating links to the collection resource.
 * */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
	
	public interface UserRepository extends MongoRepository<User, String> {

		List<User> findByLastName(@Param("name") String name);

	}
