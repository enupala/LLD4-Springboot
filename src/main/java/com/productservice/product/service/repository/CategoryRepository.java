package com.productservice.product.service.repository;

import com.productservice.product.service.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {

}
