package com.library.mapper;



import org.modelmapper.ModelMapper;

import com.library.model.Book;
import com.library.model.dto.BookDTO;

public class BookMapper implements MapperInterface{
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public BookDTO toDTO (Book book) {		
		
		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
		return bookDTO;
		
	}
	
	@Override
	public Book toEntity(BookDTO bookDto) {		
		
		Book book = modelMapper.map(bookDto, Book.class);	
		return book;
		
	}
	
}
