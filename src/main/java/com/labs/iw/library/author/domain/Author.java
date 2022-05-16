package com.labs.iw.library.author.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.labs.iw.library.book.domain.Book;
import com.labs.iw.library.infrastructure.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "author")
public class Author extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on")
	private Date modifiedOn;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "author_book_mapping",
	joinColumns = @JoinColumn( name = "author_id"),
	inverseJoinColumns = @JoinColumn( name = "book_id"))
	private List<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
        books.add(book);
        book.getAuthors().add(this);
    }
 
    public void removeBook(Book book) {
        books.remove(book);
        book.getAuthors().remove(this);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        return Long.valueOf(getId())!=null && getId() == (((Author) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
}
