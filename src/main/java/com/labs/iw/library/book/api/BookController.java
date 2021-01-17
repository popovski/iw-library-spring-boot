package com.labs.iw.library.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/{id}")
	public Book findById(@PathVariable(value = "id") Long id){
		return bookService.findById(id);
	}
}
