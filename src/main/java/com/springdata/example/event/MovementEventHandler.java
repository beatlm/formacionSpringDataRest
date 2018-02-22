package com.springdata.example.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.springdata.example.entity.Account;
import com.springdata.example.entity.Movement;
import com.springdata.example.exception.NonExistentAccountException;
import com.springdata.example.repository.AccountRepository;


@Component
@RepositoryEventHandler(Movement.class)

public class MovementEventHandler {

	@Autowired AccountRepository accountRepository;

	@HandleBeforeCreate  public void handleBeforeCreate(Movement movement) throws NonExistentAccountException {
		
		Account account=accountRepository.findByAccountNumber(movement.getAccountNumber());
		
		if(account==null) {
			throw new NonExistentAccountException("La cuenta del movimiento no existe.");
		}else {
			List <Movement> movements=account.getMovements()==null?new ArrayList<>():account.getMovements();
			movements.add(movement);
			account.setBalance(account.getBalance().add(movement.getAmount()));
			account.setMovements(movements);
			accountRepository.save(account);
		}
	}
}
