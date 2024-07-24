package com.example.readingRecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.readingRecord.entity.Book;
import com.example.readingRecord.form.BookForm;
import com.example.readingRecord.form.BookHelper;
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

	@GetMapping("/form")
	public String newBook(@ModelAttribute BookForm form) {
		form.setIsNew(true);
		return "book/form";
	}

	@PostMapping("/save")
	public String create(@Validated BookForm form, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "book/form";
		}
		Book book = BookHelper.convertBook(form);
		bookService.insertBook(book);
		attributes.addFlashAttribute("message", "新しい本が登録されました");
		return "redirect:/books";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Book target = bookService.findBookById(id);
		if (target != null) {
			BookForm form = BookHelper.convertBookForm(target);
			model.addAttribute("bookForm", form);
			return "book/form";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			return "redirect:/books";
		}
	}

	@PostMapping("/update")
	public String update(@Validated BookForm form, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			form.setIsNew(false);
			return "book/form";
		}
		Book book = BookHelper.convertBook(form);
		bookService.updateBook(book);
		attributes.addFlashAttribute("message", "本が更新されました");
		return "redirect:/books";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
		bookService.deleteBook(id);
		attributes.addFlashAttribute("message", "本が削除されました");
		return "redirect:/books";
	}
}
