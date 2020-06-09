package com.ibm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Entity
@Data
public class ProductInfo {
	
	@Id
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    private Double productPrice;

    @NotNull
    @Min(0)
    private Integer productStock;

    private String productDescription;

	@ColumnDefault("0")
    private Integer productStatus;

}
