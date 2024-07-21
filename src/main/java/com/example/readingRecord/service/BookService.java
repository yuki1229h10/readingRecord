package com.example.readingRecord.service;

import java.util.List;

import com.example.readingRecord.entity.Book;

public interface BookService {

	List<Book> findAllBooks();

	Book findBookById(Integer id);

	void insertBook(Book book);

	void updateBook(Book book);

	void deleteBook(Integer id);
}
