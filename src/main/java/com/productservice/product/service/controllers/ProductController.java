package com.productservice.product.service.controllers;

import com.productservice.product.service.dtos.ProductRequestDto;
import com.productservice.product.service.dtos.ProductResponseSelf;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import com.productservice.product.service.models.Category;
import com.productservice.product.service.models.Product;
import com.productservice.product.service.repository.CategoryRepository;
import com.productservice.product.service.repository.ProductRepository;
import com.productservice.product.service.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    IProductService productService;

    @GetMapping("/products/search")
    public Product getProductByName(@RequestParam("name") String name)
    {
       return productRepository.findByName(name);
    }
    @GetMapping("/products/search/name")
    public Product getProductByNameAndPrice(@RequestParam("name") String name,@RequestParam("price")Float price)
    {
        return productRepository.findByNameAndPrice(name,price);
    }
    @GetMapping("/search")
    public Product findByPrice(@RequestParam("price") Float price) {

        return productRepository.findByPrice(price);
    }
    @GetMapping("/categories")
    public List<Category>getCategories(){
        return null;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/getSingleProduct/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
        Product product;
        try{
            product=productService.getSingleProduct(id);
        }
        catch(Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/getAProduct/{id}")
    public ResponseEntity<ProductResponseSelf> getAProduct(@PathVariable("id") Long id) throws ProductNotPresentException {
        Product product;

        try{
            /*if(id>20 && id<=40) {
                throw new ProductNotPresentException();
            }
            else if(id>40){
                throw new ArithmeticException();
            }*/
            product=productService.getAProduct(id);
        }
       catch (ProductNotPresentException p)
       {
            return new ResponseEntity<>(new ProductResponseSelf(null,
                    "Product Doesn't exists"),HttpStatus.NOT_FOUND);
       }
        catch (ArithmeticException e)
        {
            return new ResponseEntity<>(new ProductResponseSelf(null,
                    "Something went wrong"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ProductResponseSelf(product,"success"),HttpStatus.OK);
    }

    @GetMapping("/getAProduct/exception/{id}")
    public ResponseEntity<ProductResponseSelf> getAProductException(@PathVariable("id") Long id) throws ProductNotPresentException {
        Product product;
            product=productService.getAProductException(id);

        return new ResponseEntity<>(new ProductResponseSelf(product,"success"),HttpStatus.OK);
    }
    /*@ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResponseSelf>handleInvalidProductException(){
        return new ResponseEntity<>(new ProductResponseSelf(null,
                "Product Doesn't exists from controller"),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResponseSelf>handleArithmeticException1(){
        return new ResponseEntity<>(new ProductResponseSelf(null,
                "Something went wrong from controller"),HttpStatus.INTERNAL_SERVER_ERROR);

    }*/


    @GetMapping("/products/categories")
    public List<Category>getAllCategories(){

        return productService.getAllCategories();
    }

    @GetMapping("/products/category/{name}")
    public List<Product> getAllProductsInCategory(@PathVariable("name") String name){
        return productService.getAllProductsInCategory(name);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody ProductRequestDto requestDto){
        return productService.addProduct(requestDto);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                 @RequestBody ProductRequestDto requestDto)
    {
        return productService.updateProduct(id,requestDto);
    }

    @DeleteMapping("/products/{id}")
            public Boolean deleteProduct(@PathVariable("id")Long id)
    {
        return true;
    }

}
