package jmpc.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import jmpc.spring.blog.BlogProperties;
import jmpc.spring.blog.RenderedArticle;
import jmpc.spring.blog.entity.Article;
import jmpc.spring.blog.repository.ArticleRepository;

@Controller
public class HtmlController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private BlogProperties blogProperties;
	
	@GetMapping("/")
	public String blog(Model theModel) {
		theModel.addAttribute("title", blogProperties.title);
		theModel.addAttribute("banner", blogProperties.banner);
		
//		List<RenderedArticle> renderedArticleList = new ArrayList<>();
//		
//		for(Article article : articleRepository.findAllByOrderByAddedAtDesc()) {
//			renderedArticleList.add(article.render());
//		}
//		
//		theModel.addAttribute("articles", renderedArticleList);
		
		return "blog";
	}
	
	@GetMapping("/articles")
	public String articles(Model theModel) {
		
		theModel.addAttribute("title", blogProperties.title);
		
		List<RenderedArticle> renderedArticleList = new ArrayList<>();
		
		for(Article article : articleRepository.findAllByOrderByAddedAtDesc()) {
			renderedArticleList.add(article.render());
		}
		
		theModel.addAttribute("articles", renderedArticleList);
		
		return "article-list";
	}
	
	
	@GetMapping("/article/{slug}")
	public String article(@PathVariable String slug, Model theModel) {
		

		var article = articleRepository.findBySlug(slug).render();
		
		if(article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist");
		}
		
		theModel.addAttribute("title", article.title);
		theModel.addAttribute("article", article);
		
		return "article";
	}
	
}
