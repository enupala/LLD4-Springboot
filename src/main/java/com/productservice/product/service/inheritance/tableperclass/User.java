package com.productservice.product.service.inheritance.tableperclass;

import jakarta.persistence.*;

@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
@Entity(name="tb_user")
public class User {


   @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;
}
