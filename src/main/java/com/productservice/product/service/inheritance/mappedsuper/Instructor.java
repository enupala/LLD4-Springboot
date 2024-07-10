package com.productservice.product.service.inheritance.mappedsuper;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mp_instructor")
public class Instructor extends User {

    private float avgRating;
}
