package com.productservice.product.service.services;

import com.productservice.product.service.dtos.ProductRequestDto;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import com.productservice.product.service.models.Category;
import com.productservice.product.service.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getSingleProduct(Long id);
    Product getAProduct(Long id) throws ProductNotPresentException;
    List<Product> getAllProduct();
    List<Category>getAllCategories();
    List<Product> getAllProductsInCategory(String name);
    Product addProduct(ProductRequestDto productRequestDto);
    Product updateProduct(Long id,ProductRequestDto productRequestDto);

    Product getAProductException(Long id) throws ProductNotPresentException;
}
