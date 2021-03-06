package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
//    List<Category> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);
	List<Category> findAllByOrderByCategoryType();

	Category findByCategoryType(Integer categoryType);
}
