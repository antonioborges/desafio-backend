package com.spring.blog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.blog.model.Author;
import com.spring.blog.service.AuthorService;

@Controller
public class AuthorController {

	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public ModelAndView getAuthors() {
		ModelAndView modelAndView = new ModelAndView("authors");
		// TODO recuperar lista de autores
		List<Author> authors = authorService.findAll();
		modelAndView.addObject("authors", authors);
		return modelAndView;
	}

	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	public ModelAndView getAuthorDetails(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("authorDetails");
		// TODO recuperar dados do autor por id
		Author authorDetails = authorService.findById(id);
		modelAndView.addObject("authorDetails", authorDetails);
		return modelAndView;
	}

	@RequestMapping(value = "/newauthor", method = RequestMethod.GET)
	public String getAuthorForm() {
		return "authorForm";
	}

	@RequestMapping(value = "/newauthor", method = RequestMethod.POST)
	public String saveAuthor(@Valid Author author, BindingResult result, RedirectAttributes attributes) {
		// TODO salvar o autor e caso erro apresentar uma mensagem para o usuario
		if (result.hasErrors()) {
			attributes.addFlashAttribute("message", "Check that the required fields have been completed");
			return "redirect:/authors";
		}
		author.setCreatedAt(LocalDate.now());
		authorService.save(author);
		return "redirect:/authors";
	}
}
