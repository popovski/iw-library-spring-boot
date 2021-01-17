package com.labs.iw.library.book.service;

import org.springframework.stereotype.Service;

import com.labs.iw.library.book.dto.BookPojo;

@Service
public interface BookService {

	public BookPojo findById(Long id);

	public BookPojo findByUuid(String uuid);
}
