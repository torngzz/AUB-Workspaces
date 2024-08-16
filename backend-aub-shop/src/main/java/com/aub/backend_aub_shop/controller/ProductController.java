package com.aub.backend_aub_shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aub.backend_aub_shop.model.Product;
import com.aub.backend_aub_shop.repository.ProductRepository;
import com.aub.backend_aub_shop.service.CategoryService;
import com.aub.backend_aub_shop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    // private static final String UPLOAD_DIR = "C:/Users/rithy/OneDrive/Documents/GitHub/AUB-Workspaces/backend-aub-shop/src/main/resources/static/uploads";
   

    @GetMapping(value = {"", "/"})
    public String getAllProducts(
        @RequestParam(name = "productName", required = false, defaultValue = "") String productName,
        Model m) {
        List<Product> products = productService.findByNameContainingIgnoreCase(productName);
        m.addAttribute("products", products);
        m.addAttribute("productName", productName);
        return "product-list";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model m) {
        m.addAttribute("product", new Product());
        m.addAttribute("categories", categoryService.getAllCategories());
        return "add-product";
    }

    private static final String UPLOAD_DIR = "C:/shared/images/";

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product,
                              @RequestParam("image") MultipartFile file,
                              @RequestParam("detailImages") MultipartFile[] detailImages,
                              RedirectAttributes redirectAttributes,
                              HttpServletRequest httprequest) throws IOException {
    
        // Save main image
        Path fileNameAndPath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        product.setImage_url(file.getOriginalFilename());
    
        // Save detail images
        StringBuilder detailImageUrls = new StringBuilder();
        for (MultipartFile detailImage : detailImages) {
            if (!detailImage.isEmpty()) {
                Path detailImagePath = Paths.get(UPLOAD_DIR, detailImage.getOriginalFilename());
                Files.write(detailImagePath, detailImage.getBytes());
                detailImageUrls.append(detailImage.getOriginalFilename()).append(",");
            }
        }
    
        // Remove the trailing comma
        if (detailImageUrls.length() > 0) {
            detailImageUrls.setLength(detailImageUrls.length() - 1);
        }
    
        product.setDetailImageUrl(detailImageUrls.toString());
    
        // Save the product
        productService.saveProduct(product, httprequest);
    
        return "redirect:/products";
    }
    // @PostMapping("/save")
    // public String saveProduct(@ModelAttribute("product") Product product,
    //                           Model model,
    //                           @RequestParam("image") MultipartFile file,
    //                           @RequestParam("detailimage1") MultipartFile file1,
    //                           @RequestParam("detailimage2") MultipartFile file2,
    //                           @RequestParam("detailimage3") MultipartFile file3,
    //                           RedirectAttributes redirectAttributes,
    //                           HttpServletRequest httprequest) throws IOException {
    
    //     StringBuilder fileNames = new StringBuilder();
    //     Path fileNameAndPath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
    //     fileNames.append(file.getOriginalFilename());
    //     Files.write(fileNameAndPath, file.getBytes());

    //     StringBuilder detailImageUrls = new StringBuilder();
    //     // Remove the trailing comma
    //     if (detailImageUrls.length() > 0) {
    //         detailImageUrls.setLength(detailImageUrls.length() - 1);
    //     }

    //     // Set the detail image URLs in the product
    //     product.setDetailImageUrl(detailImageUrls.toString());
    //     // Set the image URL in the product
    //     product.setImage_url(file.getOriginalFilename());
    //     //model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
    //     productService.saveProduct(product,httprequest);
    //     return "redirect:/products";    
    // }
    
    @GetMapping("/view/{id}")
    public String viewproduct(@PathVariable("id") Long id, Model m){
        Optional<Product> product = productService.findById(id);
        m.addAttribute("product", product.orElse(new Product()));

        return "view-product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model m) {
        Optional<Product> product = productService.findById(id);
        m.addAttribute("product", product.orElse(new Product()));
        m.addAttribute("categories", categoryService.getAllCategories());
        return "edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam("productId") Long productId,
                                @ModelAttribute("product") Product product,
                                Model m) {
        Product updateProduct = productService.updateProduct(product, productId);
        m.addAttribute("product", updateProduct);
       
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model m) {
        Optional<Product> product = productService.findById(id);
        m.addAttribute("product", product.orElse(new Product()));
        m.addAttribute("categories", categoryService.getAllCategories());
        return "delete-product";
    }
    
    // @GetMapping("/delete/{id}")
    // public String delete(@RequestParam("productId") Long productId, Model m) {
    //     if (productService.findById(productId).isPresent()) {
    //         productService.deleteById(productId);
    //     } else {
    //         System.out.println("Product with ID " + productId + " not found.");
    //     }
    //     return "redirect:/products";
    // }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long productId) {
        productService.deleteProductById(productId);
        logger.info("Product with ID " + productId + " deleted successfully.");
        return "redirect:/products"; 
    }

    // @PostMapping("/delete")
    // public String deleteProduct(@PathVariable Long id) {
    //     productService.deleteProductById(id);
    //     logger.info("Product with ID " + id + " deleted successfully.");
    //     return "redirect:/products"; 
    // }
     
}
