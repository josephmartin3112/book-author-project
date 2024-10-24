package com.project.Author.controller;

import com.project.Author.dto.BookDto;
import com.project.Author.model.Author;
import com.project.Author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @GetMapping("/{authorName}/books")
    public Flux<BookDto> getBooksByAuthor(@PathVariable String authorName) {
        return authorService.getBooksByAuthorName(authorName);
    }
}
