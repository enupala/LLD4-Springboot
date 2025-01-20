package com.productservice.product.service.service;

import com.productservice.product.service.dtos.ProductResponseDto;
import com.productservice.product.service.models.Product;
import com.productservice.product.service.services.IProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IProductServiceImplTest {
    private IProductServiceImpl iProductServiceImpl;
    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    IProductServiceImpl iProductService;
    @BeforeEach
    void setup(){
        iProductServiceImpl=new IProductServiceImpl();
    }
    @Test
    public void getProductsFromProductResponseDtoTest(){
        ProductResponseDto prd=new ProductResponseDto();
        prd.setId(1L);

        prd.setCategory("cat");
        prd.setDescription("sample desc");
        prd.setImage("imageurl");
        prd.setPrice(2000);

        Product prod=iProductServiceImpl.getProductsFromProductResponseDto(prd);
        assertEquals(1L,prod.getId());
        assertNotNull(prod,"product shouldnt be null");
        assertNotNull(prod.getCategory(),"catehg");
        assertEquals("sample desc",prod.getDescription());
        assertEquals("imageurl",prod.getImage());
        assertEquals(2000,prod.getPrice());

    }
    @Test
    void getSingleProduct(){
        ProductResponseDto prdt=new ProductResponseDto();
        prdt.setId(2L);
        prdt.setCategory("cat2");
        prdt.setDescription("sample desc2");
        prdt.setImage("imageurl2");
        prdt.setPrice(3000);

        when(restTemplate.getForObject("https://fakestoreapi.com/products/2",
                ProductResponseDto.class)).thenReturn(prdt);

        Product pro=iProductService.getSingleProduct(2L);
        assertEquals(2L,pro.getId());
        assertNotNull(pro,"product shouldnt be null");
        assertNotNull(pro.getCategory(),"cat2");
        assertEquals("sample desc2",pro.getDescription());
        assertEquals("imageurl2",pro.getImage());
        assertEquals(3000,pro.getPrice());


    }
    @Test
    void getAllProductsTest(){
        ProductResponseDto []prd1=new ProductResponseDto[2];
        prd1[0]=new ProductResponseDto();
        prd1[0].setId(3L);
        prd1[0].setCategory("cat3");
        prd1[0].setDescription("sample desc3");
        prd1[0].setImage("imageurl3");
        prd1[0].setPrice(4000);

        prd1[1]=new ProductResponseDto();
        prd1[1].setId(4L);
        prd1[1].setCategory("cat4");
        prd1[1].setDescription("sample desc4");
        prd1[1].setImage("imageurl4");
        prd1[1].setPrice(5000);

        when(restTemplate.getForObject("https://fakestoreapi.com/products",ProductResponseDto[].class))
                .thenReturn(prd1);

        List<Product> prds=iProductService.getAllProduct();
        assertEquals(2,prds.size());
        assertEquals(3L,prds.get(0).getId());
        assertEquals(4L,prds.get(1).getId());


    }

}
