package com.aub.backend_aub_shop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aub.backend_aub_shop.model.Product;
import com.aub.backend_aub_shop.repository.ProductRepository;
import com.aub.backend_aub_shop.util.UserSessionUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("productService")
public class ProductService {
    @Autowired ProductRepository productRepository;
    @Autowired ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    /**
     * 
     * @return
     */
    // public List<Product> findAll(){

    //    List<Product> ps = productRepository.findAll();
    //    LOGGER.info(" My Product" + ps.toString());
    //     return ps;
    // }
    @Transactional(readOnly = true)
    public Page<Product> findAll(String username, int pagenumber, int pagesize) {
        Page<Product> products = productRepository.findBycreatebyUsernameContaining(username, PageRequest.of(pagenumber, pagesize));
        LOGGER.info("My Product: " + products.toString());
        
        products.forEach(product -> {
            if (product.getCategory() != null) {
                Hibernate.initialize(product.getCategory()); 
            }
            // Assuming getUsernameById is a method in productService that takes a user ID and returns the username
            String createByUsername = productService.getUsernameById(product.getCreated_by());
            product.setCreatebyUsername(createByUsername); // Set the username in the product
        });
    
        return products;
    }

    // @Transactional(readOnly = true)
    // public List<Product> findAll() {
    //     List<Product> products = productRepository.findAll();
    //     LOGGER.info(" My Product" + products.toString());
    //     products.forEach(product -> {
    //         if (product.getCategory() != null) {
    //             Hibernate.initialize(product.getCategory()); 
    //         }
    //     });
    //     products.setCreatebyUsername(productService.getUsernameById(products.getCreated_by()));

    //     return products;
    // }

    public String getUsernameById(Long userId) {
        Product pro = productRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return pro.getCreatebyUsername();
    }

    public List<Product> searchProductsByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return productRepository.findAll(); // Return all products if the search term is empty
        }
        return productRepository.findByproductNameContainingIgnoreCase(name);
    }

    public List<Product> findByNameContainingIgnoreCase(String name){
        LOGGER.info(" My Product" );
        List<Product> products = null;
        try {
            products = productRepository.findByproductNameContainingIgnoreCase(name);
            products.forEach(product -> {
                if (product.getCategory() != null) {
                    Hibernate.initialize(product.getCategory());
    
                }   
            });
            LOGGER.info(" My Product" + products);
            
        } catch (Exception e) {
            LOGGER.error("exception :::"  , e);
        }
        return products;
    }

    /**
     * 
     * @param id
     * @return
     */
    public Optional<Product> findById(Long id){
       
        return productRepository.findById(id);
       
    }

    /**
     * 
     * @param product
     * @return
     */
    public Product saveProduct(Product product, HttpServletRequest request){
        HttpSession session = request.getSession();
        Long sessionId = UserSessionUtils.getUserId(session);
        if (sessionId == null) {
            throw new IllegalStateException("User ID not found in session. Cannot create user.");
        }
        try { 
            LOGGER.info("My Category: "  + product.toString());
            Date d = new Date();
            product.setCreated_date(d);
            product.setCreated_by(sessionId);
            return productRepository.save(product);
        } catch (Exception e) {
            LOGGER.error(" System error", e);
            return productRepository.save(product);
        }
    }


 
    /**
     * 
     * @param id
     */
    //@Transactional(readOnly = true)
    public void deleteProductById(Long id) {
        LOGGER.info("delete success " + id);
        productRepository.deleteById(id);
    }
    

    /**
     * 
     * @param product
     * @param id
     * @return
     */
    public Product updateProduct(Product product, Long id){
        Product pro = null;
        try
        { 
            
            LOGGER.info("My Category: "  + product.toString());
            Optional<Product> optionalProduct = productRepository.findById(id);
             
            if (optionalProduct.isPresent()){
                pro = optionalProduct.get();
                pro.setPro_name(product.getPro_name());
                pro.setCategory(product.getCategory());
                pro.setSale_price(product.getSale_price());
                pro.setOriginal_price(product.getOriginal_price());
                pro.setCategory_id(product.getCategory_id());
                pro.setImage_url(product.getImage_url());
                pro.setCreated_by(product.getCreated_by());
              
                
                pro.setDescription(product.getDescription());
                pro.setDetailImageUrl(product.getDetailImageUrl());
                productRepository.save(pro);
                
            }
        } catch (Exception e) {
            LOGGER.error(" System error", e); 
        }
        return pro;
    }

    
}
