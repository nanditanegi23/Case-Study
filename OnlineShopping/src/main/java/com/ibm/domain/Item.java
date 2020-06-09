package com.ibm.domain;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Item {

	private ProductInfo productInfo;

	private Integer quantity;

	 public Item(ProductInfo productInfo, Integer quantity) {
	        this.productInfo = productInfo;
	        this.quantity = quantity;
	    }
}
