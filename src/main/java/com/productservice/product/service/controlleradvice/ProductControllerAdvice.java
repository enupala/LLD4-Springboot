package com.productservice.product.service.controlleradvice;

import com.productservice.product.service.dtos.ProductResponseSelf;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResponseSelf> handleInvalidProductException(){
        return new ResponseEntity<>(new ProductResponseSelf(null,
                "Product Doesn't exists from ControllerAdvice"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResponseSelf>handleArithmeticException1(){
        return new ResponseEntity<>(new ProductResponseSelf(null,
                "Something went wrong from ControllerAdvice"),HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
