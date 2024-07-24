package com.aub.e_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired ProductService productService;

    @GetMapping(value={"","/"})
    public String GetAllProducts(Model m)
    {
        List<Product> pro = productService.findAll();
        m.addAttribute("products", pro);
        return "Interface";
    }

    @GetMapping("/getById{id}")
    public String getProById(@PathVariable("id") Long id, Model m)
    {
        Optional<Product> pro = productService.getById(id);
        m.addAttribute("product", pro.orElse(new Product()));
        return "product-view-form";
    }
}
