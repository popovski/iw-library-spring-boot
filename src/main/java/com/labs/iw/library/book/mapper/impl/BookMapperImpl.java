package com.labs.iw.library.book.mapper.impl;



import org.modelmapper.ModelMapper;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;

public class BookMapperImpl implements BookMapper{
	ModelMapper modelMapper = new ModelMapper();
	
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
