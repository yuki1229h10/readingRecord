package com.example.readingRecord.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.readingRecord.entity.Book;
import com.example.readingRecord.entity.Status;

@ExtendWith(SpringExtension.class)
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookMapperTest {

	@Autowired
	private BookMapper bookMapper;

	/**
	 * booksがnullではないことを確認する。
	 */
	@Test
	public void selectAllTest() {
		List<Book> books = bookMapper.selectAll();
		assertNotNull(books);
	}

	/**
	 * booksが空ではないことを確認する。
	 */
	@Test
	public void selectAllTest_2() {
		List<Book> books = bookMapper.selectAll();
		assertFalse(books.isEmpty());
	}

	/**
	 * bookがnullではないことを確認する。
	 */
	@Test
	public void selectByIdTest() {
		Book book = bookMapper.selectById(1);
		assertNotNull(book);
	}

	/**
	 * bookがid1に紐づくデータであることを確認する。
	 */
	@Test
	public void selectByIdTest_2() {
		Book book = bookMapper.selectById(1);
		assertEquals(1, book.getId());
		assertEquals(1, book.getTitle());
		assertEquals(1, Status.未読);
	}

}
