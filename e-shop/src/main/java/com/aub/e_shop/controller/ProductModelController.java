package com.aub.e_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.ProductModel;
import com.aub.e_shop.service.ProductModelService;

@Controller
@RequestMapping("/productmodel")
public class ProductModelController {
    @Autowired ProductModelService productModelService;

    @GetMapping("getallmodel")
    public String getAllModel(Model m)
    {
        List<ProductModel> pro = productModelService.findAllModel();
        m.addAttribute("promodel", pro);
        return "layout";
    }

   @GetMapping("/getById{id}")
    public String getModelById(@PathVariable("id") Long id, Model model) 
    {
        Optional<ProductModel> pro = productModelService.getbyId(id);
        model.addAttribute("promodel", pro.orElse(new ProductModel()));
        return "layout"; 
    }

    
}
