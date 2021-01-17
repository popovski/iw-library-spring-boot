package com.labs.iw.library.book.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.labs.iw.library.infrastructure.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "TITLE")
	private String title;
	
	@NotNull
	@Column(name = "DESCRIPTION", length = 5000)
	private String description;
}