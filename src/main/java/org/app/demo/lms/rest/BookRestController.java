package org.app.demo.lms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.app.demo.lms.service.BookService;
import org.app.demo.lms.service.CategoryService;
import org.app.demo.lms.entity.Book;
import org.app.demo.lms.entity.Category;
import org.app.demo.lms.requests.BookRequestModel;

@RestController
@RequestMapping("/api")
public class BookRestController {

	private BookService bookService;
	
	private CategoryService categoryService;
	
	@Autowired
	public BookRestController(BookService bookService, CategoryService categoryService) {
		this.bookService = bookService;
		this.categoryService = categoryService;
	}
	
	// expose "/books" and return list of books
	@GetMapping("/books")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	// add mapping for GET /books/{bookId}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		
		Book theBook = bookService.findById(bookId);
		
		if (theBook == null) {
			throw new RuntimeException("Book id not found - " + bookId);
		}
		
		return theBook;
	}
	
	// add mapping for POST /books - add new book
	
	@PostMapping("/books")
	public Book addBook(@RequestBody BookRequestModel bookRequestModel) {
		
		Category theCategory = categoryService.findById(bookRequestModel.getCategoryId());
		
		if (theCategory == null) {
			throw new RuntimeException("Category id not found - " + bookRequestModel.getCategoryId());
		}
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		Book theBook = new Book();
		theBook.setId(0);
		theBook.setName(bookRequestModel.getName());
		theBook.setAuthorName(bookRequestModel.getAuthorName());
		theBook.setCategory(theCategory);
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for PUT /books - update existing book
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody BookRequestModel bookRequestModel) {
		Category theCategory = categoryService.findById(bookRequestModel.getCategoryId());
		
		if (theCategory == null) {
			throw new RuntimeException("Category id not found - " + bookRequestModel.getCategoryId());
		}
		
		Book theBook = new Book();
		theBook.setId(bookRequestModel.getId());
		theBook.setName(bookRequestModel.getName());
		theBook.setAuthorName(bookRequestModel.getAuthorName());
		theBook.setCategory(theCategory);
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for DELETE /books/{bookId} - delete book
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		
		Book tempBook = bookService.findById(bookId);
		
		// throw exception if null
		
		if (tempBook == null) {
			throw new RuntimeException("Book id not found - " + bookId);
		}
		
		bookService.deleteById(bookId);
		
		return "Deleted book id - " + bookId;
	}	
	
}
