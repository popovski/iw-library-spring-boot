package com.labs.iw.library.author.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labs.iw.library.author.domain.Author;
import com.labs.iw.library.author.dto.AuthorPojo;

@Service
public interface AuthorService {
	
	public AuthorPojo findById(Long id);
	
	public List<AuthorPojo> getAll();
	
	public AuthorPojo getByUuid(String uuid);
	
	public Author findByUuid(String uuid);
	
	public AuthorPojo createAuthor(AuthorPojo authorPojo);
	
	public AuthorPojo updateAuthor(String uuid, AuthorPojo authorPojo);
	
	public void removeAuthor(String uuid);

}
