package com.aub.e_shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Category;
import com.aub.e_shop.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value={"","/"})
    public String getAllCategories(Model model) {
        List<Category> cate = categoryService.getAllCategories();
        model.addAttribute("categories", cate);
        return "layout"; // Thymeleaf template for listing categories
    }

    // @GetMapping("/getById{id}")
    // public String getCategoryById(@PathVariable Long id, Model model) 
    // {
    //     Optional<Category> category = categoryService.getCategoryById(id);
    //     model.addAttribute("categorybyid", category.orElse(new Category()));
    //     return "product"; // Thymeleaf template for viewing a single category
    // }
    
}
