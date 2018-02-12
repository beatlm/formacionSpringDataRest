package com.springdata.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.example.entity.User;
import com.springdata.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {
	@Autowired UserRepository userRepository;


	//Alta y borrado de usuarios
	@Test
	public void saveAndDeleteUsers() {
		User user1=saveTestUser("Usuario1", "Apellido 1");
		User user2=saveTestUser("Usuario2", "Apellido 2");

		Iterable<User> users=	userRepository.findAll();
		for(User user:users){
			log.info(user.getFirstName());
		}
		assertEquals(2,userRepository.count());

		userRepository.delete(user2.getId());
		assertEquals(1,userRepository.count());

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());

	}

	//Búsqueda de usuarios findByFirstName, findByLastName
	@Test
	public void findByFirstName() {
		User userSearch=userRepository.findByFirstName("Beatriz");
		assertNull(userSearch);

		User user1=saveTestUser("Beatriz", "Lopez");
		User user2=saveTestUser("Adrian", "Lopez");


		assertNotNull(userRepository.findByFirstName("Beatriz"));
		List <User> searchByLastName=userRepository.findByLastName("Lopez");

		assertEquals(2,searchByLastName.size());

		userRepository.delete(user1.getId());
		userRepository.delete(user2.getId());
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios por nombre y apellido
	@Test
	public void findByFirstNameAndLastName() {
		User userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNull(userSearch);

		User user1=saveTestUser("Beatriz", "Lopez");

		userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNotNull(userSearch);

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios personalizada findByNameIgnoreCase
	@Test
	public void findByFirstNameNoCaseSensitive() {
		User userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");

		assertNull(userSearch);

		User user1=saveTestUser("Beatriz", "Lopez");

		userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");
		assertNotNull(userSearch);

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}


	//Metodos count
	@Test
	public void testcountByFirstName() {

		User user1=saveTestUser("Beatriz", "Lopez");
		assertEquals(new Long(1), userRepository.countByFirstName("Beatriz"));
		userRepository.delete(user1.getId());

	}




	private User saveTestUser(String firstName, String lastName) {
		User user= new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		log.info("Insertamos usuario: "+user.getFirstName());
		return userRepository.save(user);
	}


}
