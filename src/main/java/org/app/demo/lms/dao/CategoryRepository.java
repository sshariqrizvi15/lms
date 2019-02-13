package org.app.demo.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.app.demo.lms.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
