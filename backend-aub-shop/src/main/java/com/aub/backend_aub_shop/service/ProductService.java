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
     * @param productList_Model
     * @return
     */
    public Product saveProduct(Product productList_Model){
        try { 
            LOGGER.info("My Category: "  + productList_Model.toString());
            Date d = new Date();
            productList_Model.setCreated_date(d);
            return productRepository.save(productList_Model);
        } catch (Exception e) {
            LOGGER.error(" System error", e);
            return productRepository.save(productList_Model);
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
     * @param productList_Model
     * @param id
     * @return
     */
    public Product updateProduct(Product productList_Model, Long id){
        // ProductList_Model pro = productRepository.findById(id).get();
        // pro.setName(productList_Model.getName());
        // pro.setCategory(productList_Model.getCategory());
        // pro.setPrice(productList_Model.getPrice());

        // return productRepository.save(pro);

       Optional<Product> optionalProduct = productRepository.findById(id);
       LOGGER.info(" My Product" + optionalProduct.get().toString());
       if (optionalProduct.isPresent()){
            Product pro = optionalProduct.get();
            pro.setName(productList_Model.getName());
            pro.setCategory(productList_Model.getCategory());
            pro.setSale_price(productList_Model.getSale_price());
            pro.setOriginal_price(productList_Model.getOriginal_price());
            pro.setCategory_id(productList_Model.getCategory_id());
            pro.setImage_url(productList_Model.getImage_url());
            pro.setCreated_date(productList_Model.getCreated_date());
            pro.setCreated_by(productList_Model.getCreated_by());
            pro.setDescription(productList_Model.getDescription());
            pro.setDetailImageUrl(productList_Model.getDetailImageUrl());

            return productRepository.save(pro);
       }
       return null;
    }
    
}
