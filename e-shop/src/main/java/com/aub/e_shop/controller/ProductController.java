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
@RequestMapping("/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired 
    private ProductService productService;

    @Autowired 
    private CategoryService categoryService;

    @GetMapping(value = {"", "/"})
public String getAllProducts(
    @RequestParam(name="cate_id", required=false, defaultValue = "0") Long category_id,
    @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
    @RequestParam(name = "pageSize", defaultValue = "8") int pageSize,
    Model model       
) {
    pageNumber = pageNumber != 0 ? pageNumber : 1; // Set default to 1 if not provided
    Page<Product> pro = productService.findAll(category_id, pageNumber, pageSize); 
    int totalPages = pro.getTotalPages();
    // If totalPages is zero, we need to handle it
    if (totalPages == 0) {
        totalPages = 1; // Setting totalPages to 1 to handle empty pages scenario
    }
    if( category_id != 0){
        model.addAttribute("category", categoryService.getCategoryById(category_id).get());
    }else{
        model.addAttribute("category", null);
    }
    model.addAttribute("products", pro.toList());
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", totalPages);

    LOGGER.info("This is my product. Total pages: " + totalPages);
    return "product";
}
    
    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productService.getById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Split the DETAIL_IMAGE_URL into an array of image URLs
            String[] detailImageUrl = product.getDetailImageUrl().split(",");
            // String[] detailImageUrls = product.getDetailImageUrl().split(",") != null ? product.getDetailImageUrl().split(",") : "/path/to/default/image.jpg";

            // Add the array of image URLs to the model
            model.addAttribute("productdetail", product);
            model.addAttribute("detailImageUrls", detailImageUrl); 
            return "Viewdetail"; // Thymeleaf template for product details
        } else {
            return "redirect:/products/not-found"; // Redirect to not found page
        }
    }

    // @GetMapping("/category")
    // public String getProductsByCategory(@RequestParam(name = "cate_id", required = false) Long categoryId, 
    //                                 @RequestParam(name = "cate_name", required = false) String cateName,
    //                                 Model model) {
    //     model.addAttribute("cate_name", cateName);
    //     // Add other logic to fetch products by category if needed
    //     return "product";
    // }

    // @GetMapping("/category/{category_id}")
    // public String getProductsByCategory(
    //     @PathVariable("category_id") Long categoryId,
    //     @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
    //     @RequestParam(name = "pageSize", defaultValue = "8") int pageSize,
    //     Model model
    // ) {
    //     Page<Product> pro = productService.findByCategoryId(categoryId, pageNumber, pageSize);
    //     Optional<Category> categoryOpt = categoryService.getCategoryById(categoryId);

    //     if (categoryOpt.isPresent()) {
    //         model.addAttribute("categorybyid", categoryOpt.get());
    //     } else {
    //         model.addAttribute("categorybyid", new Category());
    //     }

    //     model.addAttribute("products", pro.toList());
    //     model.addAttribute("categories", categoryService.getAllCategories());
    //     model.addAttribute("currentPage", pageNumber);
    //     model.addAttribute("pageSize", pageSize);
    //     model.addAttribute("totalPages", pro.getTotalPages());

    //     LOGGER.info("This is my product. Total pages: " + pro.getTotalPages());
    //     return "product";
    // }

    

}
