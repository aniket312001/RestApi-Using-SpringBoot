package com.restAPi.dao;

import org.springframework.data.repository.CrudRepository;

import com.restAPi.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{
	
}
