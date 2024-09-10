package com.labs.iw.library.test.utils;

import java.util.Date;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookDto;

public class TestUtil {
	public static Book createMockBookEntity() {
		Book mock = new Book();
		mock.setCreatedOn(new Date());
		mock.setUuid("Mock UUID");
		mock.setTitle("Mock Title");
		mock.setDescription("Mock Description");
		return mock;
	}
	
	public static BookDto createMockBookPojo(String title, String description) {
		BookDto mock = new BookDto();
		mock.setTitle(title);
		mock.setDescription(description);
		
		return mock;
	}
}
