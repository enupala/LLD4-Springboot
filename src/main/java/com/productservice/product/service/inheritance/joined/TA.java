package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ta")
public class TA extends User {
    private float avgRating;
    private int noOfSessions;
}
