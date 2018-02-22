package com.springdata.example.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Movement {

	@Id
	private String id;

	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private String currency;
	
	@NotNull
	private String accountNumber;
	
	@NotNull
	private Date date;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
 
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}




}
