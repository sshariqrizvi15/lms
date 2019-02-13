package org.app.demo.lms.service;

import java.util.List;

import org.app.demo.lms.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
}