package com.labs.iw.library.author.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labs.iw.library.author.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, CrudRepository<Author, Long> {
	
		public Optional<Author> findByUuid(String uuid);
		
		public List<Author> findAuthorsByBooksId(Long bookId);
}
