package com.project.Book.controller;

import com.project.Book.dto.BookDto;
import com.project.Book.model.Book;
import com.project.Book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDto bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishedYear(bookDTO.getPublishedYear());

        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/author/{authorName}")
    public List<BookDto> getBooksByAuthor(@PathVariable String authorName) {
        List<Book> books = bookService.getBooksByAuthor(authorName);
        return books.stream()
                .map(book -> new BookDto(book.getName(), book.getPrice(), book.getAuthor(), book.getPublishedYear()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public List<Book> getBooksByName(@PathVariable String name){
        return bookService.getBooksByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }
}
