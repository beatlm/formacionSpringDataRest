<<<<<<< HEAD
package com.springdata.example.entity;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
 

public class User {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id 
	@Generated(value = { "" })
	private String id;
	private String firstName;
	private String lastName;
	

	private List<Account> accounts;
 



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
=======
package com.springdata.example.entity;

import org.springframework.data.annotation.Id;
 

public class User {
	@Id 
	private String id;
	private String firstName;
	private String lastName;

	
 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
>>>>>>> branch 'master' of https://github.com/beatlm/demoSpringData
