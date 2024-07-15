package com.productservice.product.service.controllers;

import com.productservice.product.service.dtos.ProductResponseSelf;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import com.productservice.product.service.models.Product;
import com.productservice.product.service.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
    IProductService productService;
   @Test
    void getAllProducts(){
//Arrange the data
       Product p1=new Product();
       p1.setName("iphone");
       Product p2=new Product();
       p2.setName("ipad");
       Product p3=new Product();
       p3.setName("samsung");
       List<Product> expected= Arrays.asList(p1,p2,p3);

       Mockito.when(productService.getAllProduct()).thenReturn(expected);
//Act
       List<Product> actual = productController.getAllProduct();
//Assert
       Assertions.assertTrue(actual.size()==2);
   }

   @Test
  public void productNotPresentException() throws ProductNotPresentException {
//Arrange
       Mockito.when(productService.getAProduct(25L)).
               thenThrow(ProductNotPresentException.class);
 //ACt
      // productController.getAProduct(25L);//exception will be thrown here itself
//assert(In case of exception handling we have to club both "ACT" and "Assert")
       /* Assertions.assertThrows(ProductNotPresentException.class,
                ()->productController.getAProduct(25L));*/
//act
       ResponseEntity<ProductResponseSelf> actual = productController.getAProduct(25L);
       //assert
       Assertions.assertEquals(HttpStatus.NOT_FOUND,actual.getStatusCode());
   }



}
