package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "select p.* from product p where p.type = 'saleProduct' limit 12", nativeQuery = true)
   Iterable<Product> getSaleProducts();

    @Query(value = "select p.* from product p where p.type = 'recommendProduct' limit 12", nativeQuery = true)
    Iterable<Product> getRecommendProducts();

    @Query(value = "select p.* from product p where p.category_id = :categoryId", nativeQuery = true)
    Iterable<Product> getProductsByCategoryId(Integer categoryId);

}