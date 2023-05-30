package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.Product;
import com.huynh.web_ban_laptop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/sale")
    @ResponseBody
    Iterable<Product> getSaleProduct() {
        return productRepository.getSaleProducts();
    }

    @GetMapping(path = "/recommend")
    @ResponseBody
    Iterable<Product> getRecommendProducts() {
        return productRepository.getRecommendProducts();
    }
}
