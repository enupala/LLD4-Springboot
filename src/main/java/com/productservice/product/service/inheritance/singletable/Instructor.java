package com.productservice.product.service.inheritance.singletable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mp_instructor")
public class Instructor extends User {

    private float avgRating;
}
