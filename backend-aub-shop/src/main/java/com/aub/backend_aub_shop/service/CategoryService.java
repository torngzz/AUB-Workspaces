package com.aub.backend_aub_shop.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

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
/**
 * 
 * @param category
 * @return
 */
   public Category saveCategory(Category category){
    try { 
        LOGGER.info("My Category: "  + category.toString());
        Date d = new Date();
        category.setCreated_date( d );
        return categoryRepository.save(category);
    } catch (Exception e) {
        LOGGER.error(" System error", e);
        return categoryRepository.save(category);
    }
   }
   /**
    * 
    * @param id
    */
   public void deleteById(Long id){
    categoryRepository.deleteById(id);
   }
   /**
    * 
    * @param category
    * @param id
    * @return
    */
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
