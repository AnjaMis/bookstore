package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {

			log.info("save some categories");
			crepository.save(new Category("romance"));
			crepository.save(new Category("thriller"));
			crepository.save(new Category("political"));

			log.info("save a couple of books");
			brepository.save(new Book("Little Women", "Louisa May Alcott", 2015, "9788809810570", 10.13,
					crepository.findByName("romance").get(0)));
			brepository.save(new Book("Animal Farm", "George Orwell", 1991, "9780582060104", 7.04,
					crepository.findByName("political").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$HvJV.bEuomTKBbZbxCudG.l.wkiqftREj99na20.5vVTw1VloSGFm","anja@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$AgK37txcCYS2gIwcc8gNw.QZ.6EWJtwXSUG855yyKWLDngHPWSF1W", "mis@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
