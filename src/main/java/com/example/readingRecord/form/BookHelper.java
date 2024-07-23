package com.example.readingRecord.form;

import com.example.readingRecord.entity.Book;

public class BookHelper {

	public static Book convertBook(BookForm form) {
		Book book = new Book();
		book.setId(form.getId());
		book.setTitle(form.getTitle());
		book.setMemo(form.getMemo());
		book.setStatus(form.getStatus());
		return book;
	}

	public static BookForm convertBookForm(Book book) {
		BookForm form = new BookForm();
		form.setId(book.getId());
		form.setTitle(book.getTitle());
		form.setMemo(book.getMemo());
		form.setStatus(book.getStatus());
		form.setIsNew(false);
		return form;
	}

}
