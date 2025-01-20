package com.productservice.product.service.services;

import com.productservice.product.service.dtos.ProductRequestDto;
import com.productservice.product.service.dtos.ProductResponseDto;
import com.productservice.product.service.exceptions.ProductNotPresentException;
import com.productservice.product.service.models.Category;
import com.productservice.product.service.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IProductServiceImpl implements IProductService{

   @Autowired
   RestTemplate restTemplate;
    @Override
    public Product getSingleProduct(Long id) {
/*
        RestTemplate restTemplate=new RestTemplate();
*/

        ProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                ProductResponseDto.class);
        return getProductsFromProductResponseDto(response);

    }

    @Override
    public Product getAProduct(Long id) throws ProductNotPresentException {
/*
        RestTemplate restTemplate=new RestTemplate();
*/
       if(id>20 && id<=40) {
                throw new ProductNotPresentException();
            }
            else if(id>40){
                throw new ArithmeticException();
            }
        ProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                ProductResponseDto.class);
        return getProductsFromProductResponseDto(response);

    }

    @Override
    public Product getAProductException(Long id) throws ProductNotPresentException {
        if(id>20 && id<=40) {
            throw new ProductNotPresentException();
        }
        else if(id>40){
            throw new ArithmeticException();
        }
        ProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                ProductResponseDto.class);
        return getProductsFromProductResponseDto(response);
    }

    @Override
    public List<Product> getAllProduct() {
        System.out.println("service IMPL");
        ProductResponseDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);
        List<Product> output=new ArrayList<>();
        for(ProductResponseDto productResponseDto:products)
        output.add(getProductsFromProductResponseDto(productResponseDto));

        return output;
    }

    @Override
    public List<Category> getAllCategories() {
        ProductResponseDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);
        List<String> categories = new ArrayList<>();

        for (ProductResponseDto productResponseDto : products)
            categories.add(productResponseDto.getCategory());

        List<Category> cat = new ArrayList<>();

        for (String obj : categories) {
            Category category = new Category();
            category.setName(obj);
            cat.add(category);
        }

        return cat;

    }

    @Override
    public List<Product> getAllProductsInCategory(String  name) {
        ProductResponseDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products/category/"+name, ProductResponseDto[].class);
      List<Product>output=new ArrayList<>();
       for(ProductResponseDto productResponseDto:products) {
           output.add(getProductsFromProductResponseDto(productResponseDto));
       }

       return output;
    }

    @Override
    public Product addProduct(ProductRequestDto productRequestDto) {
        ProductResponseDto output = restTemplate.postForObject("https://fakestoreapi.com/products",productRequestDto, ProductResponseDto.class);
        return getProductsFromProductResponseDto(output);
    }

    @Override
    public Product updateProduct(Long id,ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = putForEntity("https://fakestoreapi.com/products/"+id,
                productRequestDto,ProductResponseDto.class).getBody();
        return getProductsFromProductResponseDto(productResponseDto);
    }



    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }


    public Product getProductsFromProductResponseDto(ProductResponseDto response) {
        Product product=new Product();
        product.setId(response.getId());
        product.setImage(response.getImage());
        product.setPrice(response.getPrice());
        product.setName(response.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(response.getCategory());
       product.setDescription(response.getDescription());
        return product;

    }
}
