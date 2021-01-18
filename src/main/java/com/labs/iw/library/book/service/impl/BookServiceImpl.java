package com.labs.iw.library.book.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public BookPojo findById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if (!optionalBook.isPresent()) {
			log.error("Resource Book with id {} is not found", id);
			throw new ResourceNotFoundException("Resource Book not found");
		}
		
		return bookMapper.entityToDto(optionalBook.get());
	}

	@Override
	public BookPojo findByUuid(String uuid) {
		log.debug("Execute findByUuid with parameter {}", uuid);
		Book bookEntity = bookRepository.findByUuid(uuid)
				.orElseThrow(() -> {
					log.error("Resource Book with uuid {} is not found", uuid);
					return new ResourceNotFoundException("Resource Book not found");
				});
		return bookMapper.entityToDto(bookEntity);
	}

	@Override
	public List<BookPojo> getAll() {
		return mapList(bookRepository.findAll(), BookPojo.class);
	}
	
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}