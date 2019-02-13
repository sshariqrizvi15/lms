package org.app.demo.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.app.demo.lms.dao.UserRepository;
import org.app.demo.lms.entity.User;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUser;
	}

	public void save(User theUser) {
		userRepository.save(theUser);
	}

	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}
}
