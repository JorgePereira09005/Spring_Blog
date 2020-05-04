package jmpc.spring.blog.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jmpc.spring.blog.entity.User;
import jmpc.spring.blog.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserRepository userRepository;
	
	@GetMapping("/")
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{login}")
	public User findOne(@PathVariable String login) {
		
		User user = userRepository.findByLogin(login);
		
		if(user==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
		}
		
		return user;
	}
}
