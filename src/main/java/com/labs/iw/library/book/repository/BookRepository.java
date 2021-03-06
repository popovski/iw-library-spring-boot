package com.labs.iw.library.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labs.iw.library.book.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, CrudRepository<Book, Long> {
	// query dsl
	public Optional<Book> findByUuid(String uuid);
}
