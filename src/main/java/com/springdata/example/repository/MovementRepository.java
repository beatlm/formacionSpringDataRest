package com.springdata.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springdata.example.entity.Movement;




@RepositoryRestResource(collectionResourceRel = "movimientos", path = "movement")

public interface MovementRepository extends PagingAndSortingRepository <Movement, String>  {

	public Page<Movement> findAll(Pageable p);

	@RestResource( rel="buscarPorNumeroCuenta", path="findByAccountNumber" )
	public Page<Movement> findByAccountNumber(@Param("accountNumber") String accountNumber, Pageable p);

}
