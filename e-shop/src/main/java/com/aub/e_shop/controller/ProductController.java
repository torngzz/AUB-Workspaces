package com.aub.e_shop.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.service.CategoryService;
import com.aub.e_shop.service.ProductService;

@Controller
@RequestMapping(value = {"", "/products"})
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired 
    private ProductService productService;
    
    @Autowired 
    private CategoryService categoryService;
    
    // @Autowired 
    // private ProductModelService productModelService;

        @GetMapping(value = {"", "/"})
    public String getAllProducts(
        // List<Product> products = productService.findAll();
        // LOGGER.info("This is my product." + products.toString());
        // model.addAttribute("products", products);
        // model.addAttribute("categories", categoryService.getAllCategories());
        @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(name = "pageSize", defaultValue = "8") int pageSize,
        Model model
        )
    {
        Page<Product> pro = productService.findAll(pageNumber, pageSize); 
        LOGGER.info("This is my product." + pro.toString());
        model.addAttribute("products", pro);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "Interface";
    }
    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productService.getById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            
            // Split the DETAIL_IMAGE_URL into an array of image URLs
            String[] detailImageUrls = product.getDetailImageUrl().split(",");
            
            // Add the array of image URLs to the model
            model.addAttribute("product", product);
            model.addAttribute("detailImageUrls", detailImageUrls);
            
            return "Viewdetail"; // Thymeleaf template for product details
        } else {
            return "redirect:/products/not-found"; // Redirect to not found page
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
