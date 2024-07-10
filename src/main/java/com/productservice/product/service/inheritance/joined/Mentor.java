package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="user_id")
@Entity(name="mentor")
public class Mentor extends User {

    private String specialization;
    private String companyName;
    private int noOfMockInterviewsTaken;
}
