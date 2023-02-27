package com.labs.iw.library.book.dto;

import java.util.Date;

import com.labs.iw.library.infrastructure.pojo.BasePojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookPojo extends BasePojo {
	@NotNull(message = "title value must not be null")
	private String title;
	@NotNull(message = "description value must not be null")
	private String description;
	private Date modifiedOn;
}
