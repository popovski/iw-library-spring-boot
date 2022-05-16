package com.labs.iw.library.book.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labs.iw.library.author.domain.Author;
import com.labs.iw.library.author.dto.AuthorPojo;
import com.labs.iw.library.infrastructure.pojo.BasePojo;

import lombok.Data;

@Data
public class BookPojo extends BasePojo {
	private String title;
	private String description;
	private Date modifiedOn;
	@JsonIgnore
	private List<AuthorPojo> authors;
}
