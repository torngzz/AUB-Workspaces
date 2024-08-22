package com.aub.e_shop.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.model.ProductOrder;
import com.aub.e_shop.service.CategoryService;
import com.aub.e_shop.service.ProductService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

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
    @RequestParam(name="cate_id", required=false, defaultValue = "0") Long categoryId,
    @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber, // Changed default to 0
    @RequestParam(name = "pageSize", defaultValue = "8") int pageSize,
    Model model       
) {
    Page<Product> pro = productService.findAll(categoryId, pageNumber, pageSize); 
    int totalPages = pro.getTotalPages();

    if (totalPages == 0) {
        totalPages = 1;
    }

    if (categoryId != 0) {
        model.addAttribute("category", categoryService.getCategoryById(categoryId).orElse(null));
    } else {
        model.addAttribute("category", null);
    }

    List<Product> products = pro.getContent();
    LOGGER.info("Number of products retrieved: " + products.size());
    model.addAttribute("products", products);
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", totalPages);

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
            return "redirect:/product/not-found"; // Redirect to not found page
        }
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
        @PostMapping("/process-payment")
        @ResponseBody
        public ResponseEntity<String> processPayment(
            @RequestBody List<ProductOrder> products,
            @RequestHeader("accountNumber") String accountNumber
            ) 
            {
                LOGGER.info("Account::>>>>>>"+ accountNumber);
            String responseMessage = productService.processPayment(products,accountNumber);
            return ResponseEntity.ok(responseMessage);
        }
    

}
