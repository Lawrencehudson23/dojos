package com.lawrence.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lawrence.dojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja,Long>{
	List<Ninja> findAll();

	List<Ninja> findByDojoId(Long id);
}
