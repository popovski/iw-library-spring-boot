package com.labs.iw.library.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labs.iw.library.book.dto.BookPojo;

@Service
public interface BookService {

	public BookPojo findById(Long id);

	public BookPojo findByUuid(String uuid);
	
	public List<BookPojo> getAll();
}
