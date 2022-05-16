package com.labs.iw.library.author.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.infrastructure.pojo.BasePojo;

import lombok.Data;

@Data
public class AuthorPojo extends BasePojo {

	private String firstName;
	private String lastName;
	private Date modifiedOn;
	public List<BookPojo> books;
}
