package com.example.personallibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personallibrary.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    public List<Book> findAllByAuthor(String author);
}