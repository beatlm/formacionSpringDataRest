package com.springdata.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.example.entity.User;
import com.springdata.example.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired UserRepository userRepository;
	@Test
	public void findAllUsers() {
		
		User miUsuario= new User();
		miUsuario.setFirstName("Beatriz");
		miUsuario.setLastName("Lopez");
		System.out.println("Insertamos usuario: "+miUsuario.getFirstName());
		userRepository.save(miUsuario);
		
		User miUsuario2= new User();
		miUsuario2.setFirstName("usuario 2");
		miUsuario2.setLastName("Lopez");
		System.out.println("Insertamos usuario: "+miUsuario2.getFirstName());
		userRepository.save(miUsuario2);
		
		
		
		Iterable<User> users=	userRepository.findAll();
		for(User user:users){
			System.out.println(user.getId());
			System.out.println(user.getFirstName());
		}
		
		
		userRepository.delete(miUsuario.getId());
		System.out.println("Borramos usuario: "+miUsuario.getId());
		
		
		System.out.println("Número de usuarios: "+ userRepository.count());

		
	}

}
