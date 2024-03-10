package hh.sof3.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository brepository;

    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) brepository.findAll(); 
    }

    @SuppressWarnings("null")
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
        return brepository.findById(id);
    }

    @SuppressWarnings("null")
    @PostMapping("/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return brepository.save(book);
    }

}
