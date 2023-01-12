package site.currychoco.assetmanager.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.service.CategoryService;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    // ---
    // page
    // ---
    @GetMapping("/manager/category/create")
    public String createCategory(){return "manager/category/addCategory";}

    // ---
    // api
    // ---
    @ResponseBody
    @PostMapping("/category")
    public void addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }
}
