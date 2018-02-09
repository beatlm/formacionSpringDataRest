package com.springdata.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		User user1= new User();
		user1.setFirstName("Usuario 1");
		user1.setLastName("Apellido 1");

		log.info("Insertamos usuario: "+user1.getFirstName());
		userRepository.save(user1);

		User user2= new User();
		user2.setFirstName("Usuario 2");
		user2.setLastName("Apellido 2");
		log.info("Insertamos usuario: "+user2.getFirstName());
		userRepository.save(user2);


		Iterable<User> users=	userRepository.findAll();
		for(User user:users){
			log.info(user.getFirstName());
		}
		assertEquals(2,userRepository.count());

		userRepository.delete(user2.getId());
		log.info("Borramos usuario: "+user2.getFirstName());

		assertEquals(1,userRepository.count());

		userRepository.delete(user1.getId());
		log.info("Borramos usuario: "+user1.getFirstName());

		assertEquals(0,userRepository.count());

	}

	//Busqueda de usuarios
	@Test
	public void findByFirstName() {
		User userSearch=userRepository.findByFirstName("Beatriz");
		assertNull(userSearch);

		User user1= new User();
		user1.setFirstName("Beatriz");
		user1.setLastName("Lopez");

		userRepository.save(user1);
		log.info("Insertamos usuario: "+user1.getFirstName());

		userSearch=userRepository.findByFirstName("Beatriz");
		assertNotNull(userSearch);


		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios por nombre y apellido
	@Test
	public void findByFirstNameAndLastName() {
		User userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNull(userSearch);

		User user1= new User();
		user1.setFirstName("Beatriz");
		user1.setLastName("Lopez");

		userRepository.save(user1);
		log.info("Insertamos usuario: "+user1.getFirstName());

		userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNotNull(userSearch);

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios
	@Test
	public void findByFirstNameNoCaseSensitive() {
		User userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");

		assertNull(userSearch);

		User user1= new User();
		user1.setFirstName("Beatriz");
		user1.setLastName("Lopez");

		userRepository.save(user1);
		log.info("Insertamos usuario: "+user1.getFirstName());

		userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");
		assertNotNull(userSearch);

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}



}
