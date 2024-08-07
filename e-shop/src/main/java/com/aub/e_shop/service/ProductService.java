package com.aub.e_shop.service;

import java.util.List;
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

    // public Page<Product> findAll(int pageNumber, int pageSize) {
    //     PageRequest pageable = PageRequest.of(pageNumber, pageSize);
    //     return productRepository.findAll(pageable);
    // }

    // public Page<Category> findByCategoryId(Long categoryId, int pageNumber, int pageSize) {
    //     PageRequest pageable = PageRequest.of(pageNumber, pageSize);
    //     return productRepository.findByCategoryId(categoryId, pageable);
    // }

    public Page<Product> findAll(Long category_id, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        if(category_id == 0)
        {
            return productRepository.findAll(pageable);
        }
        return productRepository.findBycategory_id(category_id, pageable);
    }

    public Page<Product> findByCategoryId(Long categoryId,String cate_name, int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findBycategory_id(categoryId, pageable);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findTopViewProducts()
    {
        return productRepository.findAll(PageRequest.of(0, 6)).getContent();
    }

    public void incrementViewCount(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product pro = product.get();
            Long currentViewCount = pro.getViewCount();
            if (currentViewCount == null) {
                currentViewCount = 0L;
            }
            pro.setViewCount(currentViewCount + 1);
            productRepository.save(pro);
        }
    }


}
