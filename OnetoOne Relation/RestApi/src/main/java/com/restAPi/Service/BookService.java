package com.restAPi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restAPi.dao.BookRespository;
import com.restAPi.entities.Book;

@Component
public class BookService {

	
	@Autowired
	private BookRespository bookRespository;
	
	
	public List<Book> getAllBooks(){
		
		List<Book> b = (List<Book>) bookRespository.findAll();
		return b;
	}
	
	public Book getBookById(int id) {
		Book b = bookRespository.findById(id);
		return b;
	}
	
	public void postBook(Book b) {
		bookRespository.save(b);
	}
	
	public void deleteBook(int id) {

		bookRespository.deleteById(id);;
	}
	
	public void updateBook(int id, Book book) {
		book.setId(id);
		bookRespository.save(book);
	}
	
}
