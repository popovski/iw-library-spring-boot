package com.labs.iw.library.test.integration.controller;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.book.service.BookService;
import com.labs.iw.library.infrastructure.Endpoints;
import com.labs.iw.library.test.utils.TestUtil;

@SpringBootTest(properties = "spring.jpa.hibernate.ddl-auto=none")
@AutoConfigureMockMvc
public class BookControllerTest {
	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	BookService bookService;

	@Test
	public void injectedComponentsAreNotNull() {
		assertThat(mockMvc).isNotNull();
		assertThat(objectMapper).isNotNull();
	}

	@Test
	public void getAllBooksTest_success() {
		List<BookPojo> mockBookPojoList = new ArrayList<>();
		BookPojo mock1 = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
		BookPojo mock2 = TestUtil.createMockBookPojo("mock title 2", "mock description 2");
		
		mockBookPojoList.add(mock1);
		mockBookPojoList.add(mock2);
		
		when(this.bookService.getAll()).thenReturn(mockBookPojoList);

		try {
			this.mockMvc.perform(get(Endpoints.BOOKS))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value(mock1.getTitle()))
				.andExpect(jsonPath("$[0].description").value(mock1.getDescription()))
				.andExpect(jsonPath("$[1].title").value(mock2.getTitle()));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void getByUuidTest_success() {
		String mockUuid = "mockUUID";
		BookPojo mock1 = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
				
		when(this.bookService.getByUuid(mockUuid)).thenReturn(mock1);

		try {
			this.mockMvc.perform(get(Endpoints.BOOKS + mockUuid))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value(mock1.getTitle()))
				.andExpect(jsonPath("$.description").value(mock1.getDescription()));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void createBookTest_success() {
		BookPojo mock = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
		BookPojo createdMock = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
		
		when(this.bookService.createBook(mock)).thenReturn(createdMock);

		try {
			String jsonBodyPayload = objectMapper.writer().writeValueAsString(mock);
			
			this.mockMvc.perform(post(Endpoints.BOOKS)
					.contentType(MediaType.APPLICATION_JSON)
					.content(jsonBodyPayload))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value(createdMock.getTitle()))
				.andExpect(jsonPath("$.description").value(createdMock.getDescription()));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void updateBookTest_success() {
		String mockUuid = "mockUUID";
		BookPojo mock = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
		BookPojo updatedMock = TestUtil.createMockBookPojo("mock title 1", "mock description 1");
		
		when(this.bookService.updateBook(mockUuid, mock)).thenReturn(updatedMock);

		try {
			String jsonBodyPayload = objectMapper.writer().writeValueAsString(mock);
			
			this.mockMvc.perform(put(Endpoints.BOOKS + mockUuid)
					.contentType(MediaType.APPLICATION_JSON)
					.content(jsonBodyPayload))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value(updatedMock.getTitle()))
				.andExpect(jsonPath("$.description").value(updatedMock.getDescription()));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}