package com.springdata.example.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Account {
	@Id private String id;
 
@NotNull
	private String accountNumber;
@NotNull
	private String balance;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	 
}
