package com.productservice.product.service.inheritance.mappedsuper;

import jakarta.persistence.*;


@MappedSuperclass
public class User {


   @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
