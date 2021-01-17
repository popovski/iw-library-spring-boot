package com.labs.iw.library.book.mapper;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;

public interface BookMapper {
	
	public BookPojo entityToDto (Book book);
	
	public Book dtoToEntity(BookPojo bookDto);
	
}
