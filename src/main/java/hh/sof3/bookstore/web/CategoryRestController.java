package hh.sof3.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryRestController {

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/categories")
    public @ResponseBody List<Category> categoryListRest() {
        return (List<Category>) crepository.findAll();
    }

    @SuppressWarnings("null")
    @GetMapping("categories/{categoryid}")
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryid") Long categoryid) {
        return crepository.findById(categoryid);
    }

}
