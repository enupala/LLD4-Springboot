package com.productservice.product.service.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tb_instructor")
public class Instructor extends User {

    private float avgRating;
}
