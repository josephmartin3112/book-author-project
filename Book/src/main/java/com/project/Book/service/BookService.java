package com.project.Book.service;

import com.project.Book.model.Book;
import com.project.Book.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooksByName(String name){
        return bookRepository.findByName(name);
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.findByAuthor(authorName);
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }
}
