package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibm.domain.ProductInfo;
import com.ibm.repository.ProductRepo;

@Service
public class ProductService {

	 @Autowired
	    ProductRepo productInfoRepository;

//	    @Autowired
//	    CategoryService categoryService;

	    public ProductInfo findOne(String productId) {
	        ProductInfo productInfo = productInfoRepository.findFirstByProductId(productId);
	        return productInfo;
	    }

//	    @Override
//	    public Page<ProductInfo> findUpAll(Pageable pageable) {
//	        return productInfoRepository.findAllByProductStatusOrderByProductIdAsc(ProductStatusEnum.UP.getCode(),pageable);
//	    }

	    public List<ProductInfo> findAll(Pageable pageable) {
	        return productInfoRepository.findAll();
	    }
}
