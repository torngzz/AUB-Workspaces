package com.aub.e_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.ProductModel;
import com.aub.e_shop.repository.ProductModelRepository;

@Service
public class ProductModelService {
    @Autowired private ProductModelRepository productModelRepository;

    /**
     * @return
     */
    public List<ProductModel> findAllModel()
    {
        return productModelRepository.findAll();
    }

    public Optional<ProductModel> getbyId(Long id)
    {
        return productModelRepository.findById(id);
    }
}
