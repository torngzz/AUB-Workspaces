package com.aub.e_shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aub.e_shop.model.Category;
import com.aub.e_shop.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value={"","/"})
    @ResponseBody
    public ResponseEntity<List<Category>> getAllCategories() {

        return  ResponseEntity.ok(categoryService.getAllCategories()); 
    }
   

    // @GetMapping("/getById{id}")
    // public String getCategoryById(@PathVariable Long id, Model model) 
    // {
    //     Optional<Category> category = categoryService.getCategoryById(id);
    //     model.addAttribute("categorybyid", category.orElse(new Category()));
    //     return "product"; // Thymeleaf template for viewing a single category
    // }
    
}
