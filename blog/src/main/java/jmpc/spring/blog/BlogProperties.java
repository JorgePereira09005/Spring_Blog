package jmpc.spring.blog;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("blog")
public class BlogProperties {

	public String title;
	public Banner banner;
	
	@ConstructorBinding
	public BlogProperties(String title, Banner banner) {
		this.title = title;
		this.banner = banner;
	}
	
}

