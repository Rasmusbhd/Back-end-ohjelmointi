package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@Controller
public class BookController {
@Autowired
private BookRepository brepository;
    
    public BookController(BookRepository brepository) {
        this.brepository = brepository;
    }
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }
    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/savebook")
    public String saveBook(Book book) {
        if (book != null) {
            brepository.save(book);
        }
        return "redirect:/booklist";
    }
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            brepository.deleteById(id);
        }
        return "redirect:/booklist";
    }
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        if (id != null) {
        Book book = brepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid book Id: " + id));
        model.addAttribute("book", book);
        }
        return "editbook";
    }

 }
