package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}