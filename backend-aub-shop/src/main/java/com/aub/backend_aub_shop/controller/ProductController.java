package com.aub.backend_aub_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.backend_aub_shop.model.Product;
import com.aub.backend_aub_shop.service.CategoryService;
import com.aub.backend_aub_shop.service.ProductService;

// @Controller
// @RequestMapping("/products")
// public class ProductController {
//   @GetMapping("/list")
//     public String list(){
//       return "product-list";
//   }
// }
@Controller
@RequestMapping("/products")
public class ProductController{
    @Autowired ProductService productService;
    @Autowired CategoryService categoryService;

    @GetMapping(value = {"","/"})
    public String getAllProducts(
        @RequestParam(name="productName",required=false, defaultValue="") String productName,
        Model m
        ){
        List<Product> products = productService.findByNameContainingIgnoreCase(productName); 
        m.addAttribute("products",products);
        m.addAttribute("productName",productName);
        return "product-list"; 
    }
    @GetMapping("/addProduct")
    public String addProduct(Model m){
        m.addAttribute("product", new Product());
        m.addAttribute("categories", categoryService.getAllCategories());
        return "add-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product productList_Model){
        productService.saveProduct(productList_Model);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model m){
        Optional<Product> products = productService.findById(id);
        m.addAttribute("product", products.orElse(new Product()));
        m.addAttribute("categories", categoryService.getAllCategories());
        return "edit-product";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product products , Model m){
        Product updateProduct = productService.updateProduct(products, id);
        m.addAttribute("product",updateProduct);
     
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteStaff(@RequestParam("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products"; // Redirect to staff list after deletion
    } 
}
