package com.example.personallibrary.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "{invalid.title}")
    private String title;

    @NotEmpty(message = "Must have a genre")
    private String genre;

    @NotEmpty(message = "Must have an owner")
    private String owner;

    @NotNull
    private int shelf_number;

    private int number_of_pages;

    @NotEmpty(message = "Must have an author")
    private String author;

    private String synopsis;
}