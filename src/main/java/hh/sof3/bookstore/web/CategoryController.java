package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository crepository;

    public CategoryController(CategoryRepository crepository) {
        this.crepository = crepository;
    }

    @GetMapping("/categorylist")
    public String getCategoryList(Model model) {
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/addcategory")
    public String addCategory(Category category) {
        if (category != null) {
            crepository.save(category);
        }
        return "redirect:/categorylist";
    }

}
