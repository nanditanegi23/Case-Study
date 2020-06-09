package com.ibm.repository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.ibm.domain.ItemAdd;
import com.ibm.domain.ProductInfo;
import com.ibm.domain.User;

@Repository
public interface CartRepo {

	  HttpStatus addItem(ItemAdd itemAdd);
	  HttpStatus removeItem(String productId);
	    ProductInfo updateQuantity(String productId, Integer quantity);
	    HttpStatus  checkout(User user, List<ItemAdd> iteamList);
}
