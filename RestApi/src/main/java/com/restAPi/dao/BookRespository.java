package com.restAPi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.restAPi.entities.Book;

@Component
public interface BookRespository extends CrudRepository<Book, Integer> {
	public Book findById(int id);

}
