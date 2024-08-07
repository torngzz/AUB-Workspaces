package com.aub.backend_aub_shop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aub.backend_aub_shop.model.Product;
import com.aub.backend_aub_shop.repository.ProductRepository;

@Service("productService")
public class ProductService {
    @Autowired ProductRepository productRepository;
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
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        LOGGER.info(" My Product" + products.toString());
        products.forEach(product -> {
            if (product.getCategory() != null) {
                Hibernate.initialize(product.getCategory()); 
            }
        });
        return products;
    }
    
    public List<Product> searchProductsByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return findAll(); // Return all products if the search term is empty
        }
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> findByNameContainingIgnoreCase(String name){
        LOGGER.info(" My Product" );
        List<Product> products = null;
        try {
            products = productRepository.findByNameContainingIgnoreCase(name);
            products.forEach(product -> {
                if (product.getCategory() != null) {
                    Hibernate.initialize(product.getCategory());
    
                }
            });
            LOGGER.info(" My Product" + products);
            
        } catch (Exception e) {
            e.printStackTrace();
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
    public Product saveProduct(Product product){
        try { 
            LOGGER.info("My Category: "  + product.toString());
            Date d = new Date();
            product.setCreated_date(d);
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
    public void deleteById(Long id){
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
                pro.setName(product.getName());
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
