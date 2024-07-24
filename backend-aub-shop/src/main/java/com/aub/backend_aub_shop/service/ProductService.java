package com.aub.backend_aub_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.ProductList_Model;
import com.aub.backend_aub_shop.repository.ProductRepository;

@Service("productService")
public class ProductService {
    @Autowired ProductRepository productRepository;

    /**
     * 
     * @return
     */
    public List<ProductList_Model> findAll(){
        return productRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Optional<ProductList_Model> findById(Long id){
        return productRepository.findById(id);
    }

    /**
     * 
     * @param productList_Model
     * @return
     */
    public ProductList_Model saveProduct(ProductList_Model productList_Model){
        return productRepository.save(productList_Model);
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
    public ProductList_Model updateProduct(ProductList_Model productList_Model, Long id){
        // ProductList_Model pro = productRepository.findById(id).get();
        // pro.setName(productList_Model.getName());
        // pro.setCategory(productList_Model.getCategory());
        // pro.setPrice(productList_Model.getPrice());

        // return productRepository.save(pro);

       Optional<ProductList_Model> optionalProduct = productRepository.findById(id);
       if (optionalProduct.isPresent()){
            ProductList_Model pro = optionalProduct.get();
            pro.setName(productList_Model.getName());
            pro.setCategory(productList_Model.getCategory());
            pro.setPrice(productList_Model.getPrice());
            return productRepository.save(pro);
       }
       return null;
    }
    
}
