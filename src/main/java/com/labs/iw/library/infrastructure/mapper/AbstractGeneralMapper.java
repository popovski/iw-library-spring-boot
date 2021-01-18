package com.labs.iw.library.infrastructure.mapper;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;

public abstract class AbstractGeneralMapper implements BookMapper{
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public BookPojo entityToDto (Book book) {		
		
		BookPojo bookDTO = modelMapper.map(book, BookPojo.class);
		return bookDTO;
		
	}
	
	@Override
	public Book dtoToEntity(BookPojo bookDto) {		
		
		Book book = modelMapper.map(bookDto, Book.class);	
		return book;
		
	}
	
}
