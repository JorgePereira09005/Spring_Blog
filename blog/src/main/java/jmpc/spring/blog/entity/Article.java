package jmpc.spring.blog.entity;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import jmpc.spring.blog.RenderedArticle;

@Entity
@Table(name = "article")
public class Article {
	
	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "headline")
	private String headline;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.MERGE,
												   CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@JoinColumn(name="slug")
	private String slug;
	
	@Column(name = "added_at")
	private String addedAt;

	public Article() {
		
	}
	
//	public Article(String title, String headline, String content, User user, LocalDateTime addedAt) {
//	
//		this.title = title;
//		this.headline = headline;
//		this.content = content;
//		this.user = user;
//		this.addedAt = LocalDateTime.now();
//	}
	
	public Article(String title, String headline, String content, User user) {
		
		this.title = title;
		this.headline = headline;
		this.content = content;
		this.user = user;
		this.slug =  toSlug(title);
		this.addedAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME); 
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddedAt() {
		return addedAt;
	}

	@Autowired
	public void setAddedAt() {
		this.addedAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
	
	public RenderedArticle render() {

		RenderedArticle renderedArticle = new RenderedArticle (this.getTitle(), this.getHeadline(),
				this.getContent(), this.getUser(), this.addedAt.toString() , this.slug);
		
		return renderedArticle;
	}
	
	public String toSlug(String title) {
		String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
	    String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
	    slug = EDGESDHASHES.matcher(slug).replaceAll("");
	    
	    return slug.toLowerCase(Locale.ENGLISH);
	}
	
}
