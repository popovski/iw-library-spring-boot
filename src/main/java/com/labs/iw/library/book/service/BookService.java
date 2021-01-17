package com.labs.iw.library.book.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.labs.iw.library.book.domain.Book;

@Service
public interface BookService {

	public Book findById(Long id);

	public Book findByUuid(String uuid);
}
