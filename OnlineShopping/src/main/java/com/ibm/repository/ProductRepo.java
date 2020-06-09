package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.domain.ProductInfo;

@Repository
public interface ProductRepo extends JpaRepository<ProductInfo, String>{

    ProductInfo findFirstByProductId(String id);
    
    List<ProductInfo> findAllByCategoryTypeOrderByProductIdAsc(Integer categoryType);

    
}
