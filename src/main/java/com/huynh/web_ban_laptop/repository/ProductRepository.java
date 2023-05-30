package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "select p.* from Product p where p.type = 'saleProduct'", nativeQuery = true)
   Iterable<Product> getSaleProducts();

    @Query(value = "select p.* from Product p where p.type = 'recommendProduct'", nativeQuery = true)
    Iterable<Product> getRecommendProducts();

}