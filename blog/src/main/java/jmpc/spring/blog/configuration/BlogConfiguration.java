package jmpc.spring.blog.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jmpc.spring.blog.entity.Article;
import jmpc.spring.blog.entity.User;
import jmpc.spring.blog.repository.ArticleRepository;
import jmpc.spring.blog.repository.UserRepository;

//@Configuration
//public class BlogConfiguration { //creates some example users and articles when opening the site
//
//	@Bean
//	public ApplicationRunner databaseInitializer(UserRepository userRepository, ArticleRepository articleRepository) {
//		
//		ApplicationRunner aRunner = new ApplicationRunner() {
//			
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//				var jcaesar = userRepository.save(new User("jcaesar", "Julius", "Caesar") );
//				
//				articleRepository.save(new Article ("somethingus", "lorem something something",
//						"treaty on fortnite", jcaesar));
//				
//				articleRepository.save(new Article ("another thingus", "latin babble",
//						"don't teach your kids JS", jcaesar));
//				
//				var cleo = userRepository.save(new User("cleo", "Cleopatra", "Dank") );
//				
//				articleRepository.save(new Article ("praise Rust and Java and JS and C++", "lorem something something",
//						"In computer science, functional programming is a programming paradigm—a style of building the structure and elements of computer programs—that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data. It is a declarative programming paradigm in that programming is done with expressions or declarations[1] instead of statements",
//						cleo));
//			}
//		};
//		
//		return aRunner;
//	}
//	
//	
//}

