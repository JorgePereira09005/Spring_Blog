package jmpc.spring.blog;

import jmpc.spring.blog.entity.User;

public class RenderedArticle {

	public String title;
	
	public String headline;
	
	public String content;
	
	public User user;
	
	public String addedAt;
	
	public String slug;

	public RenderedArticle(String title, String headline, String content, User user, String addedAt, String slug) {
		this.title = title;
		this.headline = headline;
		this.content = content;
		this.user = user;
		this.addedAt = addedAt;
		this.slug = slug;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

	public String getAddedAt() {
		return addedAt;
	}

	public String getSlug() {
		return slug;
	}
	
	
	
	    
}
