package com.productservice.product.service.inheritance.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mp_mentor")
public class Mentor extends User {

    private String specialization;
}
