package com.project.Book.repo;

import com.project.Book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findByAuthor(String authorName);

    List<Book> findByName(String name);
}
