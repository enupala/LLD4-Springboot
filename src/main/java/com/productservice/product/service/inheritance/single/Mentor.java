package com.productservice.product.service.inheritance.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="s_mentor")
@DiscriminatorValue("2")

public class Mentor extends User {

    private String specialization;
    private String companyName;
}
