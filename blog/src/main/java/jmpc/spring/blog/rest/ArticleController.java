package jmpc.spring.blog.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jmpc.spring.blog.entity.Article;
import jmpc.spring.blog.repository.ArticleRepository;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	private ArticleRepository articleRepository;
	
	@GetMapping("/")
	public Iterable<Article> findAll() {
		return articleRepository.findAllByOrderByAddedAtDesc();
	}
	
	@GetMapping("/{slug}")
	public Article findOne(@PathVariable String slug) {
		Article article = articleRepository.findBySlug(slug);
		
		if(article  == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist");
		}
		
		return article;
	}
}
