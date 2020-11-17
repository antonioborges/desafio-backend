package com.spring.blog.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.blog.model.Author;
import com.spring.blog.repository.AuthorRepository;
import com.spring.blog.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	private AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> findAll() {
		// TODO
		List<Author> authors = new ArrayList<>();
		authorRepository.findAll().forEach(authors::add);
		return authors;
	}

	@Override
	public Author findById(Long id) {
		// TODO
		Optional<Author> obj = authorRepository.findById(id);
		return obj.get();
	}

	@Override
	public Author save(Author author) {
		// TODO
		author.setId(null);
		return authorRepository.save(author);
	}
}
