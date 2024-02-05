package com.example.personallibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.repositories.BookRepository;


@SpringBootApplication
public class PersonalLibraryApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PersonalLibraryApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalLibraryApplication.class, args);
	}

}
