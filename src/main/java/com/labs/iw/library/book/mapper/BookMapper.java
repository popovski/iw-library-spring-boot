package com.labs.iw.library.book.mapper;

import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.book.dto.BookPojo;
import com.labs.iw.library.infrastructure.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {BaseMapper.class})
public interface BookMapper extends BaseMapper<BookPojo, Book> {

}
