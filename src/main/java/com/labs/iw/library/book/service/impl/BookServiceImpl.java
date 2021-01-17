package com.labs.iw.library.book.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public BookPojo findById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if (!optionalBook.isPresent()) {
			log.error("Resource Book with id {} is not found", id);
			throw new NotFoundException("Resource Book not found");
		}
		
		return bookMapper.entityToDto(optionalBook.get());
	}

	@Override
	public BookPojo findByUuid(String uuid) {
		log.debug("Execute findByUuid with parameter {}", uuid);
		Optional<Book> optionalBook = bookRepository.findByUuid(uuid);

		if (!optionalBook.isPresent()) {
			log.error("Resource Book with uuid {} is not found", uuid);
			throw new NotFoundException("Resource Book not found");
		}
		
		return bookMapper.entityToDto(optionalBook.get());
	}
}