package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="instructor")
public class Instructor extends User {

    private float avgRating;

}
