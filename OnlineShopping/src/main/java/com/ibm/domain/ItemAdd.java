package com.ibm.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class ItemAdd {

	@Min(value = 1)
    private Integer quantity;
    @NotEmpty
    private String productId;
    
}
