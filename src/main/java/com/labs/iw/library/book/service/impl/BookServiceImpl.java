package com.labs.iw.library.book.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.book.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book findById(Long id) {
		// TODO implement mapper
		Optional<Book> optional = bookRepository.findById(id);
		
		return optional.get();
	}
	
}
