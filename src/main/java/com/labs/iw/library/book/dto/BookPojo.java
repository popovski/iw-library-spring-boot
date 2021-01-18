package com.labs.iw.library.book.dto;

import java.util.Date;

import com.labs.iw.library.infrastructure.pojo.BasePojo;

import lombok.Data;

@Data
public class BookPojo extends BasePojo {
	private String title;
	private String description;
	private Date modifiedOn;
}
