package com.springdata.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springdata.example.entity.Movement;




@RepositoryRestResource(collectionResourceRel = "movimientos", path = "movement")

public interface MovementRepository extends CrudRepository <Movement, String>  {

	@RestResource( exported=false)
	public Movement findOne(@Param("movementId") String movementId);
}
