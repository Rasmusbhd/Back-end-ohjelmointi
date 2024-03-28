package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByBookTitle() {
        List<Book> books = brepository.findByTitle("Animal Farm");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
    }

    @SuppressWarnings("null")
    @Test
    public void testBookRepository() {
        Book book = new Book("Otsikko", "Kirjailija", 1999, "123-123", 20,null);
        brepository.save(book);
        assertThat(book.getId()).isNotNull();

        brepository.delete(book);
        assertThat(brepository.findById(book.getId()).orElse(null));
    }

    @Test
    public void findByCategoryName() {
        List<Category> categories = crepository.findByName("Scifi");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
    }

    @SuppressWarnings("null")
    @Test
    public void testCategoryRepository() {
        Category category = new Category("Horror");
        crepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();

        crepository.delete(category);
        assertThat(crepository.findById(category.getCategoryid()).orElse(null));
    }

}
