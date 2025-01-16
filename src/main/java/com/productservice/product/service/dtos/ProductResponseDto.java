package com.productservice.product.service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class ProductResponseDto {

    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }


    private float price;
    private String description;
    private String category;
    private String image;
}
