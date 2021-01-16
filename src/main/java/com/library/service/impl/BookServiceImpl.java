package com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
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
