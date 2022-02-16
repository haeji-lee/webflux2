package com.apress.prospringmvc.bookstore.controller;


import com.apress.prospringmvc.bookstore.document.Book;
import com.apress.prospringmvc.bookstore.service.BookstoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

	@Autowired
	private BookstoreServiceImpl bookstoreServiceImpl;

	@PostMapping("/create/book")
	@ResponseStatus(HttpStatus.CREATED)
	public void createBook(@RequestBody Book book) {
		bookstoreServiceImpl.createBook(book);
	}

	@GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Book> findAll() {
		return bookstoreServiceImpl.findAllBook();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Mono<Book>> findEmpById(@PathVariable("id") Integer id) {
		Mono<Book> book = bookstoreServiceImpl.findByBookId(id);
		return new ResponseEntity<Mono<Book>>(book, book != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/book")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Book> update(@RequestBody Book book) {
		return bookstoreServiceImpl.updateBook(book);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
		bookstoreServiceImpl.deleteBook(id).subscribe();
	}

}

