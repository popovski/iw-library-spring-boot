package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.library.infrastructure.domain.BaseEntity;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	
	@NotNull
	@Column(name = "TITLE")
	private String title;
	
	@NotNull
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
}
