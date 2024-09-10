package com.labs.iw.library.book.dto;

import java.util.Date;

import com.labs.iw.library.infrastructure.pojo.BaseDto;

import lombok.Data;

@Data
public class BookDto extends BaseDto {
	private String title;
	private String description;
	private Date modifiedOn;
}
