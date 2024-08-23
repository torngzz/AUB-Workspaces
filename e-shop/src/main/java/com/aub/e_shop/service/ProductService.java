package com.aub.e_shop.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service; 

import com.aub.e_shop.model.Product;
import com.aub.e_shop.model.ProductOrder;
import com.aub.e_shop.model.TransferModel;
import com.aub.e_shop.repository.ProductRepository; 
@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PaymentService paymentService;
    private static final String MERCHANT_ACCOUNT ="111112";

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
        return productRepository.findAll(PageRequest.of(0, 3)).getContent();
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

    /**
     * 
     * @param productOrders
     * @param acccountNumber
     * @return
     */
    public String processPayment(List<ProductOrder> productOrders, String acccountNumber) {
         // Fetch all products by their IDs from the repository
        List<Product> products = productRepository.findAllById(
            productOrders.stream().map(ProductOrder::getProductId).toList());

        // Create a map to easily find products by ID
        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProduct_id, Function.identity()));
        // Calculate the total amount for the products
        BigDecimal totalAmount = productOrders.stream()
                .map(order -> {
                    Product product = productMap.get(order.getProductId());
                    if (product != null) {
                        // Use BigDecimal for monetary calculations
                        BigDecimal price = BigDecimal.valueOf(product.getSale_price()); // Assuming getSalePrice() returns BigDecimal
                        BigDecimal quantity = BigDecimal.valueOf(order.getQuantity());
                        return price.multiply(quantity);
                    } else {
                        return BigDecimal.ZERO; // Handle missing product case
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

 
        TransferModel transfer = new TransferModel(
            acccountNumber //Payer
        ,MERCHANT_ACCOUNT //Merchant
        ,totalAmount);
        String payment;
        LOGGER.info("transfer:: " + transfer.toString());
        try {
            payment = paymentService.processPayment(transfer);

        } catch (IOException e) {
            LOGGER.error("An error has occored. ", e);
            payment = "The payment has been failed";
        }
        return payment;
    }
    

}
