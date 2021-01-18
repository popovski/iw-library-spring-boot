package com.labs.iw.library.book.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.labs.iw.library.infrastructure.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "description", length = 5000)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on")
	private Date modifiedOn;
}