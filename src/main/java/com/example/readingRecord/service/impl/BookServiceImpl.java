package com.example.readingRecord.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.readingRecord.entity.Book;
import com.example.readingRecord.repository.BookMapper;
import com.example.readingRecord.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;

	@Override
	public List<Book> findAllBooks() {
		return bookMapper.selectAll();
	}

	@Override
	public Book findBookById(Integer id) {
		return bookMapper.selectById(id);
	}

	@Override
	public void insertBook(Book book) {
		bookMapper.insert(book);
	}

	@Override
	public void updateBook(Book book) {
		bookMapper.update(book);
	}

	@Override
	public void deleteBook(Integer id) {
		bookMapper.delete(id);
	}
}
