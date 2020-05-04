package jmpc.spring.blog.repository;

import org.springframework.data.repository.CrudRepository;

import jmpc.spring.blog.entity.Article;

public interface ArticleRepository extends CrudRepository<Article , Long> {

	public Iterable<Article> findAllByOrderByAddedAtDesc();
	
	public Article findBySlug(String slug);
}
