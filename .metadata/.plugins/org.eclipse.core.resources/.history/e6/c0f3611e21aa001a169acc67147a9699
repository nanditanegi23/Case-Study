package com.ibm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.domain.Category;
import com.ibm.domain.ProductInfo;
import com.ibm.repository.ProductRepo;
import com.ibm.service.CategoryService;
import com.ibm.service.ProductService;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    
    @Autowired
    ProductRepo productRepo;

    //Show Products in category
    @GetMapping("/category/{type}")
    public ResponseEntity<Map<String, Object>> showOne(@PathVariable("type") Integer categoryType) throws Exception {
    	Map<String, Object> map= new HashMap<>();
    	Category res = categoryService.findByCategoryType(categoryType);
        
        List<ProductInfo> productInCategory = productRepo.findAllByCategoryTypeOrderByProductIdAsc(categoryType);
        map.put("category", res);
        map.put("products", productInCategory);	
        return ResponseEntity.ok().body(map);
    }
    
}
