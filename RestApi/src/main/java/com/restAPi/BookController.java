package com.restAPi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.restAPi.Service.BookService;
import com.restAPi.entities.Book;

@RestController 
public class BookController {
	
	@Autowired
	private BookService bookService;
//	
//	@GetMapping("/book")
//	public List<Book> run() {
//		
//		List<Book> books = bookService.getAllBooks();
//		return books;
//	}
//	
	
	

	@GetMapping("/book")
	public ResponseEntity<List<Book>> run() {
		
		List<Book> books = bookService.getAllBooks();
		
		if(books.size() <=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(books));
	}
	

	@GetMapping("/book/{id}")
	public Book run2(@PathVariable("id") int id) {
		
		Book b1 = bookService.getBookById(id);
		return b1;
	}
	
	
	@PostMapping("/book")
	public Book run3(@RequestBody Book b) {
		bookService.postBook(b);
		return b;
	}
	
	@DeleteMapping("/book/{id}")
	public String run4(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return "Deleted Successfully";
	}
	
	@PutMapping("/book/{id}")
	public String run5(@PathVariable("id") int id,@RequestBody Book b) {
		
		bookService.updateBook(id, b);
		
		
		return "updated Successfully";
	}
	
}
