package org.app.demo.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.app.demo.lms.dao.BookRepository;
import org.app.demo.lms.entity.Book;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(int theId) {
		Optional<Book> result = bookRepository.findById(theId);
		
		Book theBook = null;
		
		if (result.isPresent()) {
			theBook = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find book id - " + theId);
		}
		
		return theBook;
	}

	public void save(Book theBook) {
		bookRepository.save(theBook);
	}

	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
	}
}

