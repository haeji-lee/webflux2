package com.apress.prospringmvc.bookstore.service;

import com.apress.prospringmvc.bookstore.document.*;
import com.apress.prospringmvc.bookstore.util.BookSearchCriteria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Iuliana Cosmina on 27/07/2020
 */
public interface BookstoreService {

	Flux<Book> findBooksByCategory(String category);

	Mono<Book> findBook(String id);

	Flux<Book> findRandomBooks();

	Mono<Order> findOrder(String id);

	Mono<Book> findBookByIsbn(String isbn);

	Mono<List<Order>> findOrdersForAccountId(String accountId);

	Flux<Book> findBooks(BookSearchCriteria bookSearchCriteria);

	Mono<Order> createOrder(Cart cart, Account account);

	Mono<Book> addBook(Book book);

	Mono<Void> deleteBook(String bookIsbn);

	Flux<Book> randomBookNews();

	Mono<Void> updateByIsbn(String isbn, Mono<Book> bookMono);

	/* 신규 추가 부분 2022.02.02 */
	void createBook(Book book);

	Mono<Book> findByBookId(Integer id);

	Flux<Book> findAllBook();

	Mono<Book> updateBook(Book b);

	Mono<Void> deleteBook(Integer id);
}
