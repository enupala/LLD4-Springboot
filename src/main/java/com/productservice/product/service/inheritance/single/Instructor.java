package com.productservice.product.service.inheritance.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="s_instructor")
@DiscriminatorValue("3")

public class Instructor extends User {

    private float avgRating;
}
