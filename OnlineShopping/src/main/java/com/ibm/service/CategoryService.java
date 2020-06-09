package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Category;
import com.ibm.repository.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> findAll() {
        List<Category> res = categoryRepo.findAllByOrderByCategoryType();
      //  res.sort(Comparator.comparing(ProductCategory::getCategoryType));
        return res;
    }

    public Category findByCategoryType(Integer categoryType) throws Exception {
    	Category res = categoryRepo.findByCategoryType(categoryType);
        if(res == null) throw new Exception("Category Not Found");
        return res;
    }
//
//    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
//        List<ProductCategory> res = productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
//       //res.sort(Comparator.comparing(ProductCategory::getCategoryType));
//        return res;
//    }

    public Category save(Category productCategory) {
        return categoryRepo.save(productCategory);
    }



}
