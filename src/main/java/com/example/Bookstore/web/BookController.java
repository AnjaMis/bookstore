package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@RequestMapping("/index")
	public String book(@RequestParam(name = "title") String title, @RequestParam(name = "author") String author,
			@RequestParam(name = "year") int year, @RequestParam(name = "isbn") String isbn, @RequestParam(name = "price") double price, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("year", year);
		model.addAttribute("isbn", isbn);
		model.addAttribute("price", price);

		
		return "bookstore";
	}
}
