package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3.bookstore.domain.BookRepository;

@Controller
public class BookController {
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @Autowired
    private BookRepository repository;
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}
