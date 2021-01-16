package com.library.mapper;

import com.library.model.Book;
import com.library.model.dto.BookDTO;

public interface MapperInterface {
	
	public BookDTO toDTO (Book book);
	
	public Book toEntity(BookDTO bookDto);
	
}
