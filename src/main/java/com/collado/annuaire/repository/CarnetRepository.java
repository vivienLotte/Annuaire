package com.collado.annuaire.repository;



import org.springframework.data.repository.CrudRepository;

import com.collado.annuaire.carnet.Carnet;

public interface CarnetRepository extends CrudRepository<Carnet, Integer>{
	
}
