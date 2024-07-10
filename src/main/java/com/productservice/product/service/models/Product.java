package com.productservice.product.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Product extends BaseClass{

    private String image;
    private String description;
    private float price;
    @ManyToOne
    private Category category;
}
