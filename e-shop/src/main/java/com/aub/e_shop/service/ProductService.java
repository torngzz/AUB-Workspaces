package com.aub.e_shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.Product;
import com.aub.e_shop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired 
    private ProductRepository productRepository;

    public Page<Product> findAll(int pageNumber, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable);
    }

    public Optional<Product> getById(Long id)
    {
        return productRepository.findById(id);
    }
    

}
