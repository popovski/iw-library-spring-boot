package com.labs.iw.library.book.dto;

import com.labs.iw.library.infrastructure.pojo.BasePojo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPojo extends BasePojo {
	private String title;
	private String description;
}
