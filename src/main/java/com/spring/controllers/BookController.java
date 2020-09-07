package com.spring.controllers;

import com.spring.entities.Book;
import com.spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getAllProducts(Model model) {
        model.addAttribute("booksList", bookService.getAllProducts());
        return "books";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.addStudent(book);
        return "redirect:/books";
    }

}
