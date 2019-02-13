package org.app.demo.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.app.demo.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
