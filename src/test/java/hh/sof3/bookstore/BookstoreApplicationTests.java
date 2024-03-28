package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.web.BookController;
import hh.sof3.bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
	}

	@Test
	void contextLoads1() {
		assertThat(categoryController).isNotNull();
	}

}
