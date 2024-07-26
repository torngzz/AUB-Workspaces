package com.aub.backend_aub_shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.Category;
import com.aub.backend_aub_shop.repository.CategoryRepository;

@Service("categoryService")
public class CategoryService {
    @Autowired CategoryRepository categoryRepository;

/**
 * 
 * @param cate_name
 * @param pageNumber
 * @param pageSize
 * @return
 */
public Page<Category> findAll(String cate_name, int pageNumber, int pageSize) {
    
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
        if (cate_name == null || cate_name.trim().isEmpty()) {
            return categoryRepository.findAll(pageable);
        }
        return categoryRepository.findByNameContainingIgnoreCase(cate_name, pageable);
    }
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

   public Category saveCategory(Category category){
    return categoryRepository.save(category);
   }

   public void deleteById(Long id){
    categoryRepository.deleteById(id);
   }
   
   public Category updateCategory(Category category, Long id){
  
       Optional<Category> optionalCategory = categoryRepository.findById(id);
       if (optionalCategory.isPresent()){
            Category ca = optionalCategory.get();
            ca.setName(category.getName());
            ca.setDescription(category.getDescription());
            ca.setCreated_date(category.getCreated_date());
            ca.setCreated_by(category.getCreated_by());
       
            return categoryRepository.save(ca);
       }
       return null;
    }
}
