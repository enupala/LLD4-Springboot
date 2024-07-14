package com.productservice.product.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Category extends BaseClass{
        private String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    List<Product> products;
}
