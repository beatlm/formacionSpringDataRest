package com.springdata.example.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Movement {
	@Id private String id;

	@NotNull
	private String movementId;
	@NotNull
	private String balance;
	@NotNull
	private String currency;

	public String getMovementId() {
		return movementId;
	}
	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}


}
