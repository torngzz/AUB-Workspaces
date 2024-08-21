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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aub.backend_aub_shop.dto.ProductDTO;
import com.aub.backend_aub_shop.model.Product;
import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.repository.ProductRepository;
import com.aub.backend_aub_shop.repository.UserRepository;
import com.aub.backend_aub_shop.util.UserSessionUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserRepository userRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String username, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productName"));
        Page<Product> products = productRepository.findByCreatebyUsernameContaining(username, pageable);
        
        // Map products to include the username
        return products.map(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setProduct_id(product.getProduct_id());
            dto.setProductName(product.getPro_name());
            dto.setCategory(product.getCategory());
            dto.setOriginal_price(product.getOriginal_price());
            dto.setSale_price(product.getSale_price());
            dto.setImage_url(product.getImage_url());
            dto.setCreated_date(product.getCreated_date());
            dto.setCreateByUsername(productService.getUsernameById(product.getCreated_by()));   
            dto.setCreateByUsername(productService.getUsernameById(product.getUpdateBy()));                     
            // String createByUsername = productService.getUsernameById(product.getCreated_by());
            // product.setCreatebyUsername(createByUsername);
            return dto;
        });

        // products.forEach(product -> {
        //     if (product.getCategory() != null) {
        //         Hibernate.initialize(product.getCategory()); 
        //     }
        //     String createByUsername = productService.getUsernameById(product.getCreated_by());
        //     product.setCreatebyUsername(createByUsername);
        // });
        
        // LOGGER.info("Products fetched: " + products.toString());
        // return products;
    }

    public String getUsernameById(Long userId) {
        // Assuming getUsernameById should use a different repository or method to fetch username.
        // Adjust as needed based on your actual user management.
        // return productRepository.findById(userId)
            // .map(Product::getCreatebyUsername)
             UserModel user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getUsername();
    }

    public Page<Product> searchProductsByName(String name, int pageNumber, int pageSize) {
        if (name == null || name.trim().isEmpty()) {
            return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
        }
        return productRepository.findByProductNameContainingIgnoreCase(name, PageRequest.of(pageNumber, pageSize));
    }

    public List<Product> findByNameContainingIgnoreCase(String name, int pageNumber, int pageSize) {
        LOGGER.info("Searching products by name: " + name);
        Page<Product> products = productRepository.findByProductNameContainingIgnoreCase(name, PageRequest.of(pageNumber, pageSize));
        products.forEach(product -> {
            if (product.getCategory() != null) {
                Hibernate.initialize(product.getCategory());
            }
        });
        LOGGER.info("Products found: " + products);
        return products.getContent();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long sessionId = UserSessionUtils.getUserId(session);
        if (sessionId == null) {
            throw new IllegalStateException("User ID not found in session. Cannot create product.");
        }
        try { 
            LOGGER.info("Saving product: " + product);
            product.setCreated_date(new Date());
            product.setCreated_by(sessionId);
            return productRepository.save(product);
        } catch (Exception e) {
            LOGGER.error("Error saving product", e);
            throw new RuntimeException("Error saving product", e);
        }
    }

    @Transactional
    public void deleteProductById(Long productId) {
        try {
            if (productRepository.existsById(productId)) {
                productRepository.deleteById(productId);
                LOGGER.info("Product with ID " + productId + " deleted successfully.");
            } else {
                LOGGER.warn("Product with ID " + productId + " does not exist.");
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while trying to delete product with ID " + productId, e);
        }
    }

    public Product updateProduct(Product product, Long id) {
        try { 
            LOGGER.info("Updating product: " + product);
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                Product pro = optionalProduct.get();
                pro.setPro_name(product.getPro_name());
                pro.setCategory(product.getCategory());
                pro.setSale_price(product.getSale_price());
                pro.setOriginal_price(product.getOriginal_price());
                pro.setCategory_id(product.getCategory_id());
                pro.setImage_url(product.getImage_url());
                pro.setCreated_by(product.getCreated_by());
                pro.setDescription(product.getDescription());
                pro.setDetailImageUrl(product.getDetailImageUrl());
                return productRepository.save(pro);
            } else {
                LOGGER.warn("Product with ID " + id + " not found for update.");
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Error updating product", e); 
            throw new RuntimeException("Error updating product", e);
        }
    }
}
