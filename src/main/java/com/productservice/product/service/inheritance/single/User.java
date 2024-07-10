package com.productservice.product.service.inheritance.single;

import jakarta.persistence.*;

@DiscriminatorColumn(name="user_type",
        discriminatorType=DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="s_user")
@DiscriminatorValue("0")
public class User {


   @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
