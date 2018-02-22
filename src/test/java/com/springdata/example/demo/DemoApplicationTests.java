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

import com.springdata.example.entity.Account;
import com.springdata.example.entity.User;
import com.springdata.example.repository.AccountRepository;
import com.springdata.example.repository.MovementRepository;
import com.springdata.example.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest

public class DemoApplicationTests {
	@Autowired UserRepository userRepository;
	@Autowired AccountRepository accountRepository;
	@Autowired MovementRepository movementRepository;


	

	

	//Búsqueda de usuarios findByFirstName, findByLastName
	@Test
	public void findByFirstName() {
		User userSearch=userRepository.findByFirstName("Beatriz");
		assertNull(userSearch);

		User user1=saveTestUser("1234","Beatriz", "Lopez",null);
		User user2=saveTestUser("5678","Adrian", "Lopez",null);


		assertNotNull(userRepository.findByFirstName("Beatriz"));
		
		List <User> searchByLastName=userRepository.findByLastName("Lopez");

		assertEquals(2,searchByLastName.size());

		userRepository.delete(user1);
		userRepository.delete(user2);
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios por nombre y apellido
	@Test
	public void findByFirstNameAndLastName() {
		User userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNull(userSearch);

		User user1=saveTestUser("1234","Beatriz", "Lopez",null);

		userSearch=userRepository.findByFirstNameAndLastName( "Beatriz","Lopez");
		assertNotNull(userSearch);

		userRepository.delete(user1);
		assertEquals(0,userRepository.count());
	}


	//Busqueda de usuarios personalizada findByNameIgnoreCase
	@Test
	public void findByFirstNameNoCaseSensitive() {
		User userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");

		assertNull(userSearch);

		User user1=saveTestUser("1234","Beatriz", "Lopez",null);

		userSearch=userRepository.findByNameIgnoreCase("BEATRIZ");
		assertNotNull(userSearch);

		userRepository.delete(user1);
		assertEquals(0,userRepository.count());
	}


	//Metodos count
	@Test
	public void testcountByFirstName() {

		saveTestUser("1234","Beatriz", "Lopez", null);
		saveTestUser("2345","Beatriz", "Moreno", null);
		saveTestUser("4456","Pepe", "Moreno", null);
		assertEquals(new Long(2), userRepository.countByFirstName("Beatriz"));
		 
		userRepository.deleteAll();
		assertEquals(0L, userRepository.count());
		assert(true);

	}

/*Metodos privados para guardar usuarios, cuentas y movimientos*/
	private User saveTestUser(String nif,String firstName, String lastName, List<Account> accounts) {
		User user1= new User();
		user1.setFirstName(firstName);
		user1.setNif(nif);
		user1.setLastName(lastName);
		if(accounts!=null ) {
			user1.setAccounts(accounts);
		}
		return userRepository.save(user1);
	}


	

}
