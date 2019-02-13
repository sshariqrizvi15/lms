package org.app.demo.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.app.demo.lms.dao.CategoryRepository;
import org.app.demo.lms.entity.Category;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(int theId) {
		Optional<Category> result = categoryRepository.findById(theId);
		
		Category theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find category id - " + theId);
		}
		
		return theCategory;
	}

	public void save(Category theCategory) {
		categoryRepository.save(theCategory);
	}

	public void deleteById(int theId) {
		categoryRepository.deleteById(theId);
	}
}

