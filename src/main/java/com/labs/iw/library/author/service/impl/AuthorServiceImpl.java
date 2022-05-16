package com.labs.iw.library.author.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.iw.library.author.domain.Author;
import com.labs.iw.library.author.dto.AuthorPojo;
import com.labs.iw.library.author.mapper.AuthorMapper;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.author.service.AuthorService;
import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorMapper authorMapper;
	
	@Override
	public AuthorPojo findById(Long id) {
		Author authorEntity = authorRepository.findById(id).orElseThrow(() -> {
			log.error("Resource Author with id {} is not found", id);
			return new ResourceNotFoundException("Resource Author not found");
		});
		;

		return authorMapper.entityToDto(authorEntity);
	}

	@Override
	public List<AuthorPojo> getAll() {
		return authorMapper.mapList(authorRepository.findAll(), AuthorPojo.class);
	}
	
	@Override
	public AuthorPojo getByUuid(String uuid) {
		log.debug("Execute getByUuid with parameter {}", uuid);
		
		return authorMapper.entityToDto(findByUuid(uuid));
	}
	
	public Author findByUuid(String uuid) {
		log.debug("Execute findByUuid with parameter {}", uuid);
		return authorRepository.findByUuid(uuid).orElseThrow(() -> {
			log.error("Error: Resource Author with uuid {} is not found", uuid);
			return new ResourceNotFoundException("Resource Author not found");
		});
	}
	
	@Override
	public AuthorPojo createAuthor(AuthorPojo authorPojo) {
		log.debug("Execute createAuthor with parameters ", authorPojo);
		
		Author transientAuthor = authorMapper.dtoToEntity(authorPojo);
		
		List<BookPojo> books = authorPojo.getBooks();
		List<Book> booksDomain = new ArrayList<>();
		for (BookPojo book : books) {
			Book persistedBook = bookService.findByUuid(book.getUuid());
			if(persistedBook!=null) {
				booksDomain.add(persistedBook);
			} else {
				new ResourceNotFoundException("Resource Book not found");
			}
		}
		
		transientAuthor.setBooks(booksDomain);
		Author persistedAuthor = authorRepository.save(transientAuthor);

		return authorMapper.entityToDto(persistedAuthor);
	}

	@Override
	public AuthorPojo updateAuthor(String uuid, AuthorPojo authorPojo) {
		log.debug("Execute updateAuthor with parameters {}", authorPojo);
		Author persistedAuthor = findByUuid(uuid);
		
		List<BookPojo> books = authorPojo.getBooks();
		List<Book> booksDomain = new ArrayList<>();
		for (BookPojo book : books) {
			Book persistedBook = bookService.findByUuid(book.getUuid());
			if(persistedBook!=null) {
				booksDomain.add(persistedBook);
			} else {
				new ResourceNotFoundException("Resource Book not found");
			}
		}
		
		persistedAuthor.setBooks(booksDomain);
		
		authorMapper.mapRequestedFieldForUpdate(persistedAuthor, authorPojo);

		return authorMapper.entityToDto(authorRepository.saveAndFlush(persistedAuthor));
	}

	@Override
	public void removeAuthor(String uuid) {
		Author persistedAuthor = findByUuid(uuid);
		authorRepository.delete(persistedAuthor);
	}

}
