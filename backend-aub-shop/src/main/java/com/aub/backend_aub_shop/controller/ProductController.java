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

import com.aub.backend_aub_shop.model.ProductList_Model;
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

    @GetMapping(value = {"","/"})
    public String getAllProducts(Model m){
        List<ProductList_Model> products = productService.findAll(); 
        m.addAttribute("products",products);
        return "product-list";
      
    }

    @GetMapping("/addProduct")
    public String addProduct(Model m){
        m.addAttribute("product", new ProductList_Model());
        return "add-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") ProductList_Model productList_Model){
        productService.saveProduct(productList_Model);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model m){
        Optional<ProductList_Model> products = productService.findById(id);
        m.addAttribute("product", products.orElse(new ProductList_Model()));
        return "edit-product";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") ProductList_Model products , Model m){
        ProductList_Model updateProduct = productService.updateProduct(products, id);
        m.addAttribute("product",updateProduct);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products"; // Redirect to staff list after deletion
    }
    
    
}
