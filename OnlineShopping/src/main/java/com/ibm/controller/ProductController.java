package com.ibm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.domain.ProductInfo;
import com.ibm.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public ResponseEntity<Map<String, Object>> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "3") Integer size, Map<String, Object> map) {
		PageRequest request = PageRequest.of(page - 1, size);
		List<ProductInfo> products = productService.findAll(request);
		map.put("products", products);
		map.put("currenØtPage", page);
		map.put("size", size);
		return ResponseEntity.ok().body(map);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductInfo> showOne(@PathVariable("productId") String productId, Model model) {

		ProductInfo productInfo = productService.findOne(productId);

		// Product is not available
		if ("Unavailable".equals(productInfo.getProductStatus())) {
			return new ResponseEntity<ProductInfo>(productInfo, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(productInfo);
	}

}
