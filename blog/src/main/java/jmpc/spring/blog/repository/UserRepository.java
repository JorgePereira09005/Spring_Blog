package jmpc.spring.blog.repository;

import org.springframework.data.repository.CrudRepository;

import jmpc.spring.blog.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByLogin(String login);
}
