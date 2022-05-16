package com.labs.iw.library.author.mapper;

import com.labs.iw.library.author.domain.Author;
import com.labs.iw.library.author.dto.AuthorPojo;
import com.labs.iw.library.infrastructure.mapper.GeneralMapper;

public interface AuthorMapper extends GeneralMapper<AuthorPojo, Author> {
	
	public void mapRequestedFieldForUpdate(Author entity, AuthorPojo dto);

}
