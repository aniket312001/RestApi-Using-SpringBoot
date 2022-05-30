package com.restAPi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPi.Service.AuthorService;
import com.restAPi.dao.AuthorRepository;
import com.restAPi.entities.Author;
import com.restAPi.entities.Book;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author")
	public List<Author> getall() {
		
		List<Author> a =  this.authorService.getAllAuthor();
		return a;
		
	}
	
	
	@GetMapping("/author/{id}")
	public Author getById(@PathVariable("id") int id) {
		
		return this.authorService.getAuthorById(id);
	}

	@PostMapping("/author")
	public Author run3(@RequestBody Author b) {
		authorService.postAuthor(b);
		return b;
	}
	
	@DeleteMapping("/author/{id}")
	public String run4(@PathVariable("id") int id) {
		authorService.deleteAuthor(id);
		return "Deleted Successfully";
	}
	
	@PutMapping("/author/{id}")
	public String run5(@PathVariable("id") int id,@RequestBody Author b) {
		
		authorService.updateAuthor(id, b);
		
		
		return "updated Successfully";
	}
	
}
