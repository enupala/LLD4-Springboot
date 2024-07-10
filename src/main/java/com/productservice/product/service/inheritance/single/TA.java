package com.productservice.product.service.inheritance.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="s_ta")
@DiscriminatorValue("1")

public class TA extends User {
    private float avgRating;
    private int noOfSessions;
}
