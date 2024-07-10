package com.productservice.product.service.inheritance.mappedsuper;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mp_ta")
public class TA extends User{
    private float avgRating;
    private int noOfSessions;
}
