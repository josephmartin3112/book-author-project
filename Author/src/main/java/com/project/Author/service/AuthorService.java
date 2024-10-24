package com.project.Author.service;

import com.project.Author.dto.BookDto;
import com.project.Author.model.Author;
import com.project.Author.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Flux<BookDto> getBooksByAuthorName(String authorName) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/books/author/{authorName}", authorName) // Replace with your Books service URL
                .retrieve()
                .bodyToFlux(BookDto.class);
    }
}
