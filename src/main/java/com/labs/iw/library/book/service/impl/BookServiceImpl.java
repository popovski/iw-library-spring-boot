package com.labs.iw.library.book.service.impl;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookMapper bookMapper;

	@Override
	public BookPojo findById(Long id) {
		Book bookEntity = bookRepository.findById(id).orElseThrow(() -> {
			log.error("Resource Book with id {} is not found", id);
			return new ResourceNotFoundException("Resource Book not found");
		});
		;

		return bookMapper.entityToDto(bookEntity);
	}
	
	@Override
	public BookPojo getByUuid(String uuid) {
		log.debug("Execute getByUuid with parameter {}", uuid);
		
		return bookMapper.entityToDto(findByUuid(uuid));
	}
	
	public Book findByUuid(String uuid) {
		log.debug("Execute findByUuid with parameter {}", uuid);
		return bookRepository.findByUuid(uuid).orElseThrow(() -> {
			log.error("Error: Resource Book with uuid {} is not found", uuid);
			return new ResourceNotFoundException("Resource Book not found");
		});
	}

	@Override
	public List<BookPojo> getAll() {
		return bookMapper.mapList(bookRepository.findAll(), BookPojo.class);
	}

	@Override
	public BookPojo createBook(BookPojo bookPojo) {
		log.debug("Execute createBook with parameters ", bookPojo);
		Book transientBook = bookMapper.dtoToEntity(bookPojo);
		Book persistedBook = bookRepository.save(transientBook);

		return bookMapper.entityToDto(persistedBook);
	}

	@Override
	public BookPojo updateBook(String uuid, BookPojo bookPojo) {
		log.debug("Execute updateBook with parameters {}", bookPojo);
		Book persistedBook = findByUuid(uuid);
		// map the bookPojo into PersistedBook
		bookMapper.mapRequestedFieldForUpdate(persistedBook, bookPojo);

		return bookMapper.entityToDto(bookRepository.saveAndFlush(persistedBook));
	}

	@Override
	public void removeBook(String uuid) {
		Book persistedBook = findByUuid(uuid);
		bookRepository.delete(persistedBook);
	}
}