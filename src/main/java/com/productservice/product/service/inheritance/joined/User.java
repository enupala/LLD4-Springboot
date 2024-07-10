package com.productservice.product.service.inheritance.joined;

import jakarta.persistence.*;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity(name="user")
public class User {


   @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
