package com.springdata.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springdata.example.entity.Account;



@RepositoryRestResource(collectionResourceRel = "cuentas", path = "account")

public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

	
	@RestResource( rel="buscarPorBanco", path="findByBankName" )
	public Page<Account> findByBankName(@Param("bankName") String bankName, Pageable p);
}
