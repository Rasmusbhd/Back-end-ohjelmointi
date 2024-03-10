package hh.sof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category c1 = new Category("Scifi");
			crepository.save(c1);
			Category c2 = new Category("Comic");
			crepository.save(c2);
			Category c3 = new Category("Fiction");
			crepository.save(c3);
			
			brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 0.0, c1));
			brepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 0.0, c2));

			User user1 = new User("user", "$2a$10$Rpx60MEd1pDdjtZFgW9DMeh6N9QJwShxBYyvx0QLGl.Uf2O84UzDi", "USER", "user@gmail.com");
			User user2 = new User("admin", "$2a$10$VKY3p0EEHB7HKKht54S6QeCZPuYiQEYUvRr3w4c8LMflE/t0GQjAe", "ADMIN", "admin@gmail.com");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}

