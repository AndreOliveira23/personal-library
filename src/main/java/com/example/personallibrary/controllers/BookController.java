package com.example.personallibrary.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.repositories.BookRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
    
    @Autowired
    private BookRepository repository;

    @CrossOrigin
    @GetMapping("/books")
    public List<Book> allBooks() {
        return repository.findAll();
    }

    @CrossOrigin
    @GetMapping("/books/{id}")
    public ResponseEntity getOneBook(@PathVariable(name = "id") int id) {
        
        Optional<Book> book = repository.findById(id);        
        
        return book.isPresent() ? ResponseEntity.ok(book.get()) : 
                                  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book was found");
    }

    @CrossOrigin
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @CrossOrigin
    @PutMapping("/books/{id}")
    public ResponseEntity updateBook(@PathVariable(name = "id") int id, @RequestBody Book book) {
        return repository.findById(id)
        .map( existingBook -> {
            
            book.setId(existingBook.getId());
            repository.save(book);
            return ResponseEntity.status(HttpStatus.OK).body("Book updated successfully");
        })
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with id {"+id+"} was found"));

    }

    @CrossOrigin
    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        return repository.findById(id)
        .map(book -> {
            repository.delete(book);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");

        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book wih id {"+id+"} was found")); 
    }

    @CrossOrigin
    @GetMapping("/books/search/{name}")
    public ResponseEntity find(@PathVariable String name){

        List<Book> books = repository.findAll()
                                     .stream()
                                     .filter(book -> book.getTitle().toLowerCase()
                                     .contains(name.toLowerCase()))
                                     .collect(Collectors.toList());

        return ResponseEntity.ok(books);
    }
}