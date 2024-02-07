package com.example.personallibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.personallibrary.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findAllByAuthorIgnoreCaseContaining(String author);
    List<Book> findByTitleIgnoreCaseContaining(String title);

    @Query("SELECT b FROM Book b WHERE b.shelf_number = ?1")
    List<Book> findAllByShelfNumber(int shelf_number);

    List<Book> findAllByGenreIgnoreCaseContaining(String genre);
    List<Book> findByOwnerIgnoreCase(String owner);
}