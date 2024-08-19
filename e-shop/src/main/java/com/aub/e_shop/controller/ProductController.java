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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.service.CategoryService;
import com.aub.e_shop.service.ProductService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        // model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        LOGGER.info("This is my product. Total pages: " + totalPages);
        return "product";
    }

  
    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        
        productService.incrementViewCount(id);
        Optional<Product> productOptional = productService.getById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Split the DETAIL_IMAGE_URL into an array of image URLs
            String[] detailImageUrl = product.getDetailImageUrl().split(",");
            // String[] detailImageUrls = product.getDetailImageUrl().split(",") != null ? product.getDetailImageUrl().split(",") : "/path/to/default/image.jpg";

            // Add the array of image URLs to the model
            model.addAttribute("productdetail", product);
            model.addAttribute("detailImageUrls", detailImageUrl); 
            // model.addAttribute("viewcount", productOptional.get());
            return "Viewdetail"; // Thymeleaf template for product details
        } else {
            return "redirect:/products/not-found"; // Redirect to not found page
        }
    }

    @PostMapping("/add-to-cart")
    public RedirectView addToCart(
        @RequestParam("productName") String productName,
        @RequestParam("salePrice") String salePrice,
        @RequestParam("totalPrice") String totalPrice,
        @RequestParam("imageUrl") String imageUrl,
        HttpServletResponse response,
        HttpServletRequest request) { // Add HttpServletRequest parameter
    
        // Set cookies for product details
        setCookie(response, "productName", productName);
        setCookie(response, "salePrice", salePrice);
        setCookie(response, "totalPrice", totalPrice);
        setCookie(response, "imageUrl", imageUrl);
    
        // Optionally, also set/update cart item count here
        int itemCount = Integer.parseInt(getCookie(request, "cartItemCount", "0")) + 1;
        setCookie(response, "cartItemCount", String.valueOf(itemCount));

        LOGGER.info("Added to cart: {} {} {} {}", productName, salePrice, totalPrice, imageUrl);
    
        return new RedirectView("/products/cart-page");
    }

    private void setCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(cookie);
    }

    private String getCookie(HttpServletRequest request, String name, String defaultValue) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return defaultValue;
    }

    @GetMapping("/cart-page")
    public String viewCartPage(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        String productName = null;
        String salePrice = null;
        String totalPrice = null;
        String imageUrl = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "productName":
                        productName = cookie.getValue();
                        break;
                    case "salePrice":
                        salePrice = cookie.getValue();
                        break;
                    case "totalPrice":
                        totalPrice = cookie.getValue();
                        break;
                    case "imageUrl":
                        imageUrl = cookie.getValue();
                        break;
                }
            }
        }

        // String productName = getCookie(request, "productName", "N/A");
        // String salePrice = getCookie(request, "salePrice", "0.00");
        // String totalPrice = getCookie(request, "totalPrice", "0.00");
        // String imageUrl = getCookie(request, "imageUrl", "");

        // Log values for debugging
        System.out.println("Product Name: " + productName);
        System.out.println("Sale Price: " + salePrice);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Image URL: " + imageUrl);

        LOGGER.info("Retrieved from cookies: {} {} {} {}", productName, salePrice, totalPrice, imageUrl);
        
        model.addAttribute("productName", productName);
        model.addAttribute("salePrice", salePrice);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("imageUrl", imageUrl);

        return "card-detail";
    }

    

}
