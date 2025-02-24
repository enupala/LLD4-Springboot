package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="user_id")
@Entity(name="ta")
public class TA extends User {
    private float avgRating;
    private int noOfSessions;
}
