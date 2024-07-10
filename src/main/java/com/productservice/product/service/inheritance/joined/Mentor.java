package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mentor")
public class Mentor extends User {

    private String specialization;
    private String companyName;
    private int noOfMockInterviewsTaken;
}
