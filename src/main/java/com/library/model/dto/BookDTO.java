package com.library.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class BookDTO implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 30, message = "The title name must be at least 2 characters")
	private String title;
	
	@NotNull
	@Size(min = 2, max = 30, message = "The category name must be at least 2 characters")
	private String category;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyyMMdd")
	@Past(message = "Year of publishing needs to be in the past!")
	private LocalDate yearOfPublishing;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(LocalDate yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
