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
		User user1=saveTestUser("Usuario1", "Apellido 1",20);
		User user2=saveTestUser("Usuario2", "Apellido 2",30);

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

		User user1=saveTestUser("Beatriz", "Lopez",20);
		User user2=saveTestUser("Adrian", "Lopez",30);


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

		User user1=saveTestUser("Beatriz", "Lopez",20);

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

		User user1=saveTestUser("Beatriz", "Lopez",20);

		userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");
		assertNotNull(userSearch);

		userRepository.delete(user1.getId());
		assertEquals(0,userRepository.count());
	}


	//Metodos count
	@Test
	public void testCountByFirstName() {

		User user1=saveTestUser("Beatriz", "Lopez",20);
		assertEquals(new Long(1), userRepository.countByFirstName("Beatriz"));
		userRepository.delete(user1.getId());

	}


	//Busqueda de usuarios ordenada
	@Test
	public void testFindAllByOrderByFirstName() {
		saveTestUser("Beatriz", "Lopez",20);
		saveTestUser("Angel", "Moreno",30);
		saveTestUser("Carlos", "Dominguez",40);
		List <User>usersAsc=userRepository.findAllByOrderByFirstNameAsc();
		assertEquals("Angel",usersAsc.get(0).getFirstName());
		assertEquals("Beatriz",usersAsc.get(1).getFirstName());
		assertEquals("Carlos",usersAsc.get(2).getFirstName());

		List <User>usersDesc=userRepository.findAllByOrderByFirstNameDesc();
		assertEquals("Carlos",usersDesc.get(0).getFirstName());
		assertEquals("Beatriz",usersDesc.get(1).getFirstName());
		assertEquals("Angel",usersDesc.get(2).getFirstName());

		userRepository.deleteAll();

	}
	
	//Busqueda de usuarios ordenada
		@Test
		public void testFindAllByOrderByAge() {
			saveTestUser("Beatriz", "Lopez",20);
			saveTestUser("Angel", "Moreno",15);
			saveTestUser("Carlos", "Dominguez",56);
			saveTestUser("Felipe", "Dominguez",40);
			List <User>usersAsc=userRepository.findAllByOrderByAgeAsc();
			assertEquals("Angel",usersAsc.get(0).getFirstName());
			assertEquals("Beatriz",usersAsc.get(1).getFirstName());
			assertEquals("Felipe",usersAsc.get(2).getFirstName());
			assertEquals("Carlos",usersAsc.get(3).getFirstName());

		

			userRepository.deleteAll();

		}



	private User saveTestUser(String firstName, String lastName, int age) {
		User user= new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);
		log.info("Insertamos usuario: "+user.getFirstName());
		return userRepository.save(user);
	}


}
