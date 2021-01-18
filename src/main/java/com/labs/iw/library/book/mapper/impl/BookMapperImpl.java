package com.labs.iw.library.book.mapper.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.mapper.BookMapper;
import com.labs.iw.library.infrastructure.mapper.AbstractGeneralMapper;

@Component
public class BookMapperImpl extends AbstractGeneralMapper implements BookMapper {
	
	@Autowired
	public BookMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public BookPojo entityToDto (Book book) {		
		return this.modelMapper.map(book, BookPojo.class);
	}
	
	@Override
	public Book dtoToEntity(BookPojo bookDto) {		
		return this.modelMapper.map(bookDto, Book.class);	
	}
	
	public void mapRequestedFieldForUpdate(Book entity, BookPojo dto) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setModifiedOn(new Date());
	}
}