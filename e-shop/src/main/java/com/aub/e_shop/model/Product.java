package com.aub.e_shop.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    // @Column(name = "product_id")
    private Long product_id;

    // @Column(name = "pro_name")
    private String pro_name;

    // @Column(name = "original_price")
    private Double original_price;

    // @Column(name = "sale_price")    
    private Double sale_price;

    // @Column(name = "category_id")
    private String category_id;

    // @Column(name = "image")
    private String image_url;

    // @Column(name = "created_date")
    private Date created_date;

    // @Column(name = "created_by")
    private String created_by;

    private String description;

    private String detail_ImageUrl;


    public Product()
    {

    }

    public Product(String name, double price, String category, String image, String description) {

        this.pro_name = name;
        this.sale_price = price;
        this.category_id = category;
        this.detail_ImageUrl = image;
        this.description = description;
    }

    public String getProductDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Product ID: ").append(product_id).append("\n");
        details.append("Name: ").append(pro_name).append("\n");
        details.append("Category: ").append(category_id).append("\n");
        details.append("Price: ").append(sale_price).append("\n");
        details.append("Description: ").append(description).append("\n");
        return details.toString();
    }

    public String getDetailImage() {
        return detail_ImageUrl;
    }
    
    public void setDetailImage(String de) {
        this.detail_ImageUrl = de;
    }
    

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String des) {
        this.description = des;
    }

    public String getImage_url() {
        return image_url;
    }
    
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    public Double getSale_price() {
        return sale_price;
    }

    public void setSale_price(Double sale_price) {
        this.sale_price = sale_price;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
    public String getDetailImageUrl() {
        return detail_ImageUrl;
    }

    public void setDetailImageUrl(String detail_ImageUrl) {
        this.detail_ImageUrl = detail_ImageUrl;
    }



    
 
}
