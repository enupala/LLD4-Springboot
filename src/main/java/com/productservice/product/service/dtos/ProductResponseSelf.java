package com.productservice.product.service.dtos;

import com.productservice.product.service.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class ProductResponseSelf {

    private Product product;

    public ProductResponseSelf(Product product, String message) {
        this.product = product;
        this.message = message;
    }

    private String message;
}

