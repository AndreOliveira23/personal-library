package com.example.personallibrary.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.repositories.BookRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookQuery {

    @Autowired
    private BookRepository repository;

    public List<Book> find(String field, String value) {
        List<Book> books = null;

        switch (field.toLowerCase()) {
            case "author":
                books = findByAuthor(value);
                break;

            case "title":
                books = findByTitle(value);
                break;

            case "shelf_number":
                Integer number = Integer.parseInt(value);
                books = findyShelfNumber(number);
                break;
            
            case "genre":
                books = findByGenre(value);
                break;

            case "owner":
                books = findByOwner(value);
                break;
        }

        if (field.equalsIgnoreCase("author")) {
            books = findByAuthor(value);
        }
        return books;
    }

    public List<Book> findByAuthor(String author) {
        return repository.findAllByAuthorIgnoreCaseContaining(author);
    }

    public List<Book> findByTitle(String author) {
        return repository.findByTitleIgnoreCaseContaining(author);
    }

    public List<Book> findyShelfNumber(int shelf_number) {
        return repository.findAllByShelfNumber(shelf_number);
    }

    public List<Book> findByGenre(String genre) {
        return repository.findAllByGenreIgnoreCaseContaining(genre);
    }

    public List<Book> findByOwner(String owner) {
        return repository.findByOwnerIgnoreCase(owner);
    }
}