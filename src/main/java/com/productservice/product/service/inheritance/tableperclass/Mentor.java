package com.productservice.product.service.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tb_mentor")
public class Mentor extends User {

    private String specialization;
    private String companyName;
}
