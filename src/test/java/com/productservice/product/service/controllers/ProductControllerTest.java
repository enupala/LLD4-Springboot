package com.productservice.product.service.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.product.service.dtos.ProductResponseSelf;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import com.productservice.product.service.models.Category;
import com.productservice.product.service.models.Product;
import com.productservice.product.service.repository.ProductRepository;
import com.productservice.product.service.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.Arrays;
import java.util.List;

@WebMvcTest(ProductController.class)
//@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;
   /* @Autowired
    ProductRepository productRepository;*/

    @MockBean
    IProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllProducts() {
//Arrange the data
        Product p1 = new Product();
        p1.setName("iphone");
        Product p2 = new Product();
        p2.setName("ipad");
        Product p3 = new Product();
        p3.setName("samsung");
        List<Product> expected = Arrays.asList(p1, p2, p3);

        Mockito.when(productService.getAllProduct()).thenReturn(expected);
//Act
        List<Product> actual = productController.getAllProduct();
//Assert
        Assertions.assertTrue(actual.size() == 2);
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
        Assertions.assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

    @Test
    public void getAllCateogries(){
        //Arrange the data
        Category c1 = new Category();
        c1.setName("iphones");
        Category c2 = new Category();
        c2.setName("Android");
        Category c3 = new Category();
        c3.setName("ipads");

        List<Category> expected=Arrays.asList(c1,c2,c3);

        Mockito.when(productService.getAllCategories()).thenReturn(expected);

        //Act

        List<Category> actual = productController.getAllCategories();
        Assertions.assertTrue(actual.size()==2);



    }
@Test
public void getAllProductsInCategory() throws Exception {
    Product p1 = new Product();
    p1.setName("samsung");
    Product p2 = new Product();
    p2.setName("iphone");
    List<Product> expected = Arrays.asList(p1, p2);
    Mockito.when(productService.getAllProductsInCategory("phones")).thenReturn(expected);

    //act
   /* List<Product> actual = productController.getAllProductsInCategory("phones");
    Assertions.assertEquals(expected,actual);*/
    MvcResult mvcResult = mockMvc.perform(get("/products/category/phones")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected))).andReturn();



    //System.out.println(mvcResult.getResponse().getContentAsString());
    Assertions.assertTrue(mvcResult.getResponse().getContentAsString().contains("iphone"));

    MvcResult mvcResult2 = mockMvc.perform(get("/products/category/phones")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()) .andExpect(jsonPath("$[0].name").value("samsung"))
            .andExpect(jsonPath("$[1].name").value("iphone")).andReturn();
    System.out.println(mvcResult2.getResponse().getContentAsString());
}

}
