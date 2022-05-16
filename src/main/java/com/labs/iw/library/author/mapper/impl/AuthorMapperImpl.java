package com.labs.iw.library.author.mapper.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labs.iw.library.author.domain.Author;
import com.labs.iw.library.author.dto.AuthorPojo;
import com.labs.iw.library.author.mapper.AuthorMapper;
import com.labs.iw.library.infrastructure.mapper.AbstractGeneralMapper;

@Component
public class AuthorMapperImpl extends AbstractGeneralMapper implements AuthorMapper {

	@Autowired
	public AuthorMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public AuthorPojo entityToDto(Author author) {
		return this.modelMapper.map(author, AuthorPojo.class);
	}

	@Override
	public Author dtoToEntity(AuthorPojo authorDto) {
		return this.modelMapper.map(authorDto, Author.class);
	}

	@Override
	public void mapRequestedFieldForUpdate(Author entity, AuthorPojo dto) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setModifiedOn(new Date());
	}

}
