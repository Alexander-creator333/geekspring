package com.spring.services;

import com.spring.entities.Book;
import com.spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllProducts() {
        return (List<Book>) bookRepository.findAll();
    }

    public void addStudent(Book book) {
        bookRepository.save(book);
    }
}
