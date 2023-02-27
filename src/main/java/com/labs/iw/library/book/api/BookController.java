package com.labs.iw.library.book.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.Endpoints;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.BOOKS)
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/{uuid}")
	public BookPojo getByUuid(@PathVariable(value = "uuid") String uuid) {
		return bookService.getByUuid(uuid);
	}

	@GetMapping
	public List<BookPojo> getAll() {
		return bookService.getAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public BookPojo createBook(@Valid @RequestBody BookPojo requestBookPojo) {
		return bookService.createBook(requestBookPojo);
	}

	@PutMapping("/{uuid}")
	@ResponseStatus(value = HttpStatus.OK)
	public BookPojo updateBook(@PathVariable(value = "uuid") String uuid, @Valid @RequestBody BookPojo requestBookPojo) {
		return bookService.updateBook(uuid, requestBookPojo);
	}
	
	@DeleteMapping("/{uuid}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeBook(@PathVariable(value = "uuid") String uuid) {
		bookService.removeBook(uuid);
	}
}