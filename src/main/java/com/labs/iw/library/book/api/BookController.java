package com.labs.iw.library.book.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.Endpoints;

@RestController
@RequestMapping(Endpoints.BOOKS)
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/{uuid}")
	public BookPojo findByUuid(@PathVariable(value = "uuid") String uuid){
		return bookService.findByUuid(uuid);
	}
	
	@GetMapping
	public List<BookPojo> getAll(){
		return bookService.getAll();
	}
}
