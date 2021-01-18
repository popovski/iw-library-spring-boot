package com.labs.iw.library.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;

@Service
public interface BookService {

	public BookPojo findById(Long id);

	public BookPojo getByUuid(String uuid);
	
	public Book findByUuid(String uuid);
	
	public List<BookPojo> getAll();
	
	public BookPojo createBook(BookPojo bookPojo);
	
	public BookPojo updateBook(String uuid, BookPojo bookPojo);
	
	public void removeBook(String uuid);
}
