package com.springdata.example.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Account {

	@Id
	private String id;
	
	@NotNull
	private String bankName;

	@NotNull
	private String accountNumber;

	@NotNull
	private BigDecimal balance = new BigDecimal(0);

	@DBRef 
	private List<Movement> movements;

 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


}
