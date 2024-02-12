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

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository) {
		return (args) -> {
			log.info("save a couple of books");
			Book b1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 0.0);
			Book b2 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 0.0);
			brepository.save(b1);
			brepository.save(b2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository crepository) {
		return (args) -> {
			log.info("Save some sample categories");
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Comic");
			Category c3 = new Category("Fiction");
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);

			log.info("Fetch all the categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

}

