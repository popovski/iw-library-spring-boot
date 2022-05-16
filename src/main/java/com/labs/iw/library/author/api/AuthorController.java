package com.labs.iw.library.author.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labs.iw.library.author.dto.AuthorPojo;
import com.labs.iw.library.author.service.AuthorService;
import com.labs.iw.library.infrastructure.Endpoints;

@RestController
@RequestMapping(Endpoints.AUTHORS)
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/{uuid}")
	public AuthorPojo getByUuid(@PathVariable(value = "uuid") String uuid) {
		return authorService.getByUuid(uuid);
	}
	
	@GetMapping
	public List<AuthorPojo> getAll() {
		return authorService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AuthorPojo createAuthor(@RequestBody AuthorPojo requestAuthorPojo) {
		return authorService.createAuthor(requestAuthorPojo);
	}

	@PutMapping("/{uuid}")
	@ResponseStatus(value = HttpStatus.OK)
	public AuthorPojo updateAuthor(@PathVariable(value = "uuid") String uuid, @RequestBody AuthorPojo requestAuthorPojo) {
		return authorService.updateAuthor(uuid, requestAuthorPojo);
	}
	
	@DeleteMapping("/{uuid}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAuthor(@PathVariable(value = "uuid") String uuid) {
		authorService.removeAuthor(uuid);
	}

}
