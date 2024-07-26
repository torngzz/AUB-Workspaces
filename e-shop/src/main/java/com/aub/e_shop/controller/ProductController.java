package com.aub.e_shop.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.service.CategoryService;
import com.aub.e_shop.service.ProductModelService;
import com.aub.e_shop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired 
    private ProductService productService;
    
    @Autowired 
    private CategoryService categoryService;
    
    @Autowired 
    private ProductModelService productModelService;

    @GetMapping(value = {"", "/"})
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAll();
        LOGGER.info("This is my product." + products.toString());
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "Interface";
    }

    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "Viewdetail";
        } else {
            return "redirect:/products/not-found";
        }
    }

    // @GetMapping("/categories")
    // public String getCategories(Model model) {
    //     List<Category> categories = categoryService.getAllCategories();
    //     List<ProductModel> productModels = productModelService.findAllModel();
    //     model.addAttribute("categories", categories);
    //     model.addAttribute("promodel", productModels);
    //     return "layout"; // Thymeleaf template for listing categories
    // }

}
