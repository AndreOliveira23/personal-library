package com.example.personallibrary;

import com.example.personallibrary.entities.Book;
import com.example.personallibrary.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;


@SpringBootApplication
public class PersonalLibraryApplication extends SpringBootServletInitializer implements CommandLineRunner {
	Logger log = LoggerFactory.getLogger(PersonalLibraryApplication.class);

	@Autowired
	BookRepository repository;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PersonalLibraryApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonalLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Book book1 = Book.builder()
				.title("Pride and Prejudice")
				.genre("Fiction")
				.owner("John Doe")
				.shelf_number(1)
				.number_of_pages(432)
				.author("Jane Austen")
				.synopsis("A romantic novel of manners.")
				.build();

		Book book2 = Book.builder()
				.title("1984")
				.genre("Dystopian")
				.owner("Alice Smith")
				.shelf_number(2)
				.number_of_pages(328)
				.author("George Orwell")
				.synopsis("A novel about a totalitarian regime and surveillance.")
				.build();

		Book book3 = Book.builder()
				.title("The Great Gatsby")
				.genre("Classic")
				.owner("Bob Johnson")
				.shelf_number(3)
				.number_of_pages(218)
				.author("F. Scott Fitzgerald")
				.synopsis("A story of wealth and disillusionment in the Jazz Age.")
				.build();

		Book book4 = Book.builder()
				.title("To Kill a Mockingbird")
				.genre("Classic")
				.owner("Charlie Brown")
				.shelf_number(4)
				.number_of_pages(281)
				.author("Harper Lee")
				.synopsis("A novel about racial injustice and childhood innocence.")
				.build();

		Book book5 = Book.builder()
				.title("Moby Dick")
				.genre("Adventure")
				.owner("David White")
				.shelf_number(5)
				.number_of_pages(635)
				.author("Herman Melville")
				.synopsis("A story of obsession and revenge against a great white whale.")
				.build();

		Book book6 = Book.builder()
				.title("Brave New World")
				.genre("Science Fiction")
				.owner("Eve Green")
				.shelf_number(6)
				.number_of_pages(311)
				.author("Aldous Huxley")
				.synopsis("A novel depicting a dystopian future society.")
				.build();

		Book book7 = Book.builder()
				.title("The Catcher in the Rye")
				.genre("Coming-of-age")
				.owner("Frank Black")
				.shelf_number(7)
				.number_of_pages(277)
				.author("J.D. Salinger")
				.synopsis("A story about teenage alienation and rebellion.")
				.build();

		Book book8 = Book.builder()
				.title("War and Peace")
				.genre("Historical")
				.owner("Grace Blue")
				.shelf_number(8)
				.number_of_pages(1225)
				.author("Leo Tolstoy")
				.synopsis("A novel depicting Russian society during the Napoleonic Wars.")
				.build();

		Book book9 = Book.builder()
				.title("The Hobbit")
				.genre("Fantasy")
				.owner("Henry Gold")
				.shelf_number(9)
				.number_of_pages(310)
				.author("J.R.R. Tolkien")
				.synopsis("A fantasy adventure about a hobbit's journey.")
				.build();

		Book book10 = Book.builder()
				.title("Crime and Punishment")
				.genre("Psychological")
				.owner("Ivy Silver")
				.shelf_number(10)
				.number_of_pages(671)
				.author("Fyodor Dostoevsky")
				.synopsis("A novel exploring morality, guilt, and redemption.")
				.build();

		List<Book> books = List.of(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10);
		repository.saveAll(books);

		log.info("Database initialized!");
	}
}
