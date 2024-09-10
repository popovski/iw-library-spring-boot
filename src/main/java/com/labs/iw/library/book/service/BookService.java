package com.labs.iw.library.book.service;

import java.util.List;

import com.labs.iw.library.book.dto.BookDto;
import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;

@Service
public interface BookService {

	public BookDto findById(Long id);

	public BookDto getByUuid(String uuid);
	
	public Book findByUuid(String uuid);
	
	public List<BookDto> getAll();
	
	public BookDto createBook(BookDto bookDto);
	
	public BookDto updateBook(String uuid, BookDto bookDto);
	
	public void removeBook(String uuid);
}
