package com.restAPi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restAPi.dao.AuthorRepository;
import com.restAPi.entities.Author;
import com.restAPi.entities.Book;


@Component
public class AuthorService {

	
	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAllAuthor() {
		// TODO Auto-generated method stub
				
		List<Author> a =  (List<Author>) authorRepository.findAll();
		return a;
	}

	public Author getAuthorById(int id) {
		// TODO Auto-generated method stub
		Optional<Author> a = authorRepository.findById(id);
		return a.get();
	}

	public void postAuthor(Author b) {
		// TODO Auto-generated method stub
		authorRepository.save(b);
	}

	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		authorRepository.deleteById(id);
	}

	public void updateAuthor(int id, Author b) {
		// TODO Auto-generated method stub
		b.setId(id);
		authorRepository.save(b);
	}

}
