package com.expressMovies.repository;

import org.springframework.data.repository.CrudRepository;

import com.expressMovies.entity.Director;

public interface DirectorRepository extends CrudRepository<Director, Integer> {
	
}
