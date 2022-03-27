package com.vinegrad.colours.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinegrad.colours.model.Colour;

@Repository
public interface ColourRepository extends CrudRepository<Colour, UUID> {
	
	List<Colour> findAll();

}
