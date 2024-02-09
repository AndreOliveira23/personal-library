package com.example.personallibrary.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.query.BookQuery;
import com.example.personallibrary.repositories.BookRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookQuery bookQuery;

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
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam Map<String, String> queryParams) throws NoResourceFoundException {
        try {
            return bookQuery.find(queryParams.entrySet().iterator().next().getKey(),
            queryParams.entrySet().iterator().next().getValue());

        } catch (NoSuchElementException e) {
            throw new NoResourceFoundException(HttpMethod.GET, "");
        }
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return repository.save(book);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(name = "id") int id, @RequestBody @Valid Book book) {
        return repository.findById(id)
        .map( existingBook -> {       
            book.setId(existingBook.getId());
            repository.save(book);
            return book;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        Book book = repository.findById(id)
                              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(book);
    }
}