package com.labs.iw.library.test.integration.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.repository.BookRepository;
import com.labs.iw.library.test.utils.TestUtil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lombok.extern.slf4j.Slf4j;
import javax.transaction.Transactional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Slf4j
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void injectedComponentsAreNotNull(){
		assertThat(bookRepository).isNotNull();
	}
	
	@Test
	public void getAllBooks() {
		Book mock = TestUtil.createMockBookEntity();
		bookRepository.save(mock);

		List<Book> bookList = bookRepository.findAll();
		assertThat(bookList).isNotNull();
	}
	
	@Test
	public void createNewBook() {
		Book mock = TestUtil.createMockBookEntity();
		bookRepository.save(mock);
		
		Optional<Book> persistedOptionalMock = bookRepository.findByUuid(mock.getUuid());
		assertThat(persistedOptionalMock).isPresent();
		Book persistedMock = persistedOptionalMock.get();
		
		assertThat(persistedMock.getUuid()).isEqualTo(mock.getUuid());
		assertThat(persistedMock.getTitle()).isEqualTo(mock.getTitle());
		assertThat(persistedMock.getDescription()).isEqualTo(mock.getDescription());
		assertThat(persistedMock.getCreatedOn()).isEqualTo(mock.getCreatedOn());
	}

	@Test
	public void updateBook() {
		// create book and verify
		Book mock = TestUtil.createMockBookEntity();
		bookRepository.save(mock);
		Date modifiedOnDate = new Date();
		
		Optional<Book> persistedOptionalMock = bookRepository.findByUuid(mock.getUuid());
		assertThat(persistedOptionalMock).isPresent();
		assertThat(persistedOptionalMock.get().getUuid()).isEqualTo(mock.getUuid());
		assertThat(persistedOptionalMock.get().getTitle()).isEqualTo(mock.getTitle());
		assertThat(persistedOptionalMock.get().getDescription()).isEqualTo(mock.getDescription());
		assertThat(persistedOptionalMock.get().getCreatedOn()).isEqualTo(mock.getCreatedOn());
		// update book and verify
		Book mockForUpdate = persistedOptionalMock.get();
		mockForUpdate.setTitle("Updated Mock Title");
		mockForUpdate.setDescription("Updated Mock Description");
		mockForUpdate.setModifiedOn(modifiedOnDate);
		
		bookRepository.saveAndFlush(mockForUpdate);
		
		Optional<Book> persistedUpdatedOptionalMock = bookRepository.findByUuid(mockForUpdate.getUuid());
		assertThat(persistedUpdatedOptionalMock).isPresent();
		
		Book persistedUpdatedMock = persistedUpdatedOptionalMock.get();
		
		assertThat(persistedUpdatedMock.getUuid()).isEqualTo(mockForUpdate.getUuid());
		assertThat(persistedUpdatedMock.getTitle()).isEqualTo(mockForUpdate.getTitle());
		assertThat(persistedUpdatedMock.getDescription()).isEqualTo(mockForUpdate.getDescription());
		assertThat(persistedUpdatedMock.getCreatedOn()).isEqualTo(mockForUpdate.getCreatedOn());
		assertThat(persistedUpdatedMock.getModifiedOn()).isEqualTo(modifiedOnDate);
	}
	
	@Test
	public void removeBook() {
		// create book and verify
		Book mock = TestUtil.createMockBookEntity();
		bookRepository.save(mock);
		
		Optional<Book> persistedOptionalMock = bookRepository.findByUuid(mock.getUuid());
		assertThat(persistedOptionalMock).isPresent();
		Book persistedMock = persistedOptionalMock.get();
		
		assertThat(persistedMock.getUuid()).isEqualTo(mock.getUuid());
		assertThat(persistedMock.getTitle()).isEqualTo(mock.getTitle());
		assertThat(persistedMock.getDescription()).isEqualTo(mock.getDescription());
		assertThat(persistedMock.getCreatedOn()).isEqualTo(mock.getCreatedOn());
		// remove book
		bookRepository.delete(persistedMock);
		Optional<Book> deletedOptionalMock = bookRepository.findByUuid(mock.getUuid());
		assertThat(deletedOptionalMock).isNotPresent();
	}
}