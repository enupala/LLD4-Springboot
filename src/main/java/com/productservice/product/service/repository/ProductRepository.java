package com.productservice.product.service.repository;

import com.productservice.product.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByDescription(String description);
    @Query("select p from Product p where p.name=:name")
    Optional<Product> findByName(@Param("name") String name);
    Product findByPrice(Float price);
}
