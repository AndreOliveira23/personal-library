package com.example.personallibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personallibrary.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
}