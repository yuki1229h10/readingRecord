package com.example.readingRecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.readingRecord.entity.Book;
import com.example.readingRecord.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@GetMapping
	public String showBookList(Model model) {
		model.addAttribute("books", bookService.findAllBooks());
		return "book/list";
	}

	@GetMapping("/{id}")
	public String showBookDetail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Book book = bookService.findBookById(id);
		if (book != null) {
			model.addAttribute("book", bookService.findBookById(id));
			return "book/detail";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			return "redirect:/books";
		}
	}
}
