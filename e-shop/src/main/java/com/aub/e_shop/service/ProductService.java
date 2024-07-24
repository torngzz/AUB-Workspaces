package com.aub.e_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    /**
     * @return
     */
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public Optional<Product> getById(Long id)
    {
        return productRepository.findById(id);
    }
    

}
