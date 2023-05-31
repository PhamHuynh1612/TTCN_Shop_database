package com.huynh.web_ban_laptop.controler;


import com.huynh.web_ban_laptop.model.ProductCategory;
import com.huynh.web_ban_laptop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/category")
public class    ProductCategoryController {
    @Autowired
    ProductCategoryRepository productcategoryRepository;

    @PostMapping(path = "/add")
    @ResponseBody ProductCategory addCategory(@RequestBody ProductCategory productCategory) {
        return productcategoryRepository.save(productCategory);
    }

    @PostMapping(path = "/delete")
    @ResponseBody String deleteCategory(@RequestBody Integer id) {
        productcategoryRepository.deleteById(id);
        return "Success";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    Iterable<ProductCategory> getAll() {
        return productcategoryRepository.findAll();
    }


}


