package com.example.personallibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.exceptions.ResourceNotFoundException;
import com.example.personallibrary.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
    
    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public java.util.List<Book> allBooks() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getOneBook(@PathVariable int id) {
        return repository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return repository.findById(id)
        .map( existingBook -> {
            existingBook.setAuthor(book.getAuthor());
            existingBook.setGenre(book.getGenre());
            existingBook.setId(book.getId());
            existingBook.setNumber_of_pages(book.getNumber_of_pages());
            existingBook.setOwner(book.getOwner());
            existingBook.setShelf_number(book.getShelf_number());
            existingBook.setSynopsis(book.getSynopsis());
            existingBook.setTitle(book.getTitle());
            return repository.save(existingBook);
        })
        .orElseThrow(ResourceNotFoundException::new);
    }
}
