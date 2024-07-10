package com.productservice.product.service.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tb_ta")
public class TA extends User {
    private float avgRating;
    private int noOfSessions;
}
