package com.productservice.product.service.repository;

import com.productservice.product.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   Product findByDescription(String description);
    Product findByName(@Param("name") String name);
    Product findByPrice(Float price);
    Product findByNameAndPrice(String name,Float price);
}
