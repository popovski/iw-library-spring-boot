package com.library.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.model.Book;

@Service
public interface BookService {

	public Book findById(Long id);
}
