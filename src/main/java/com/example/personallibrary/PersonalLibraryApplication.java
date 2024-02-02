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

	@Bean
	public CommandLineRunner run (@Autowired BookRepository repository){
		return args -> {
			Book book1 = Book.builder()
							 .title("The Book Title")
							 .genre("Fiction")
							 .owner("John Doe")
							 .shelf_number(2)
							 .number_of_pages(300)
							 .author("Jane Author")
							 .synopsis("A brief summary of the book")
							 .build();

			Book book2 = Book.builder()
							 .title("Segundo livro")
							 .genre("Fantasy")
							 .owner("Jane Smith")
							 .shelf_number(3)
							 .number_of_pages(350)
							 .author("John Author")
							 .synopsis("An updated summary of the book")
							 .build();

			repository.save(book1);
			repository.save(book2);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalLibraryApplication.class, args);
	}

}
