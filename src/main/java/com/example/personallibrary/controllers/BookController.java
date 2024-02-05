package com.example.personallibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.exceptions.BookNotFoundException;
import com.example.personallibrary.repositories.BookRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository repository;

    @CrossOrigin
    @GetMapping
    public List<Book> allBooks() {
        return repository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable(name = "id") int id) {
        return repository.findById(id)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No book was found"));                              
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(name = "id") int id, @RequestBody Book book) {
        return repository.findById(id)
        .map( existingBook -> {       
            book.setId(existingBook.getId());
            repository.save(book);
            return book;
        })
        .orElseThrow(BookNotFoundException::new);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        Book book = repository.findById(id)
                              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(book);
    }
}