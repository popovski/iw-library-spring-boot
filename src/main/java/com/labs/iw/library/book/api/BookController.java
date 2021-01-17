package com.labs.iw.library.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.Endpoints;

@RestController
@RequestMapping(Endpoints.BOOK)
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/{uuid}")
	public Book findByUuid(@PathVariable(value = "uuid") String uuid){
		return bookService.findByUuid(uuid);
	}
}
