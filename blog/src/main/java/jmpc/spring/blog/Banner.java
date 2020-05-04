package jmpc.spring.blog;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Banner {

	public String title;
	public String content;
	
	public Banner() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
