package com.labs.iw.library.book.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book findById(Long id) {
		// TODO implement mapper
		Optional<Book> optional = bookRepository.findById(id);
		
		return optional.get();
	}
	// TODO add java doc commnets	
	@Override
	public Book findByUuid(String uuid) {
		log.debug("Execute findByUuid with parameter {}", uuid);

		Optional<Book> optionalBook = bookRepository.findByUuid(uuid);

		if (!optionalBook.isPresent()) {
			log.error("Resource Book with uuid {} is not found", uuid);
			throw new NotFoundException("Resource Book not found");
		}
		
		// TODO implement mapper
		return optionalBook.get();
	}
}