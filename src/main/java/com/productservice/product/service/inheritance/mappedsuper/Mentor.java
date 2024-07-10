package com.productservice.product.service.inheritance.mappedsuper;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mp_mentor")
public class Mentor extends User {

    private String specialization;
    private String companyName;
}
