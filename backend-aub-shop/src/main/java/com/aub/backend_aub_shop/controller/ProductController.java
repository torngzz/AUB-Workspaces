package com.aub.backend_aub_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
  @GetMapping("/list")
    public String list(){
      return "product-list";
  }
}
