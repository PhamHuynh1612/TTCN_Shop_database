package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}