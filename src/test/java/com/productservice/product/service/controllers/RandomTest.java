package com.productservice.product.service.controllers;

import com.productservice.product.service.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
@SpringBootTest
public class RandomTest
{
    @Autowired
    ProductController productController;
    @Test
    public void onePlusOneIsTwo(){
        productController.getAllProduct();
        //arrange the data
       // int a=1,b=12;

        //act
      //  int c=a+b;
        //assertion
       // assert c==13;//not giving much info about errors
       // Assertions.assertTrue(c==138);//still not providing much info , jus telling whether its true/false, its not sufficient to a dev to debug the issue
      /* Assertions.assertEquals(13,c);//recommended way of using
       Assertions.assertThrows(NullPointerException.class,()->sample.add(a,b));//when we call this method then it has to be thrown nullpointer exception
        Assertions.assertNull(a);//means the object should be null
        Assertions.assertNotNull(b);//means the object shouldnt be null
        int[]expected={};
        int[]actual={};
        Assertions.assertArrayEquals(expected,actual);//used to help to compare array of elements
        List<String> expectedWords= Arrays.asList("cat","dog");
        List<String>actualWords=Arrays.asList("cat","dog");
        Assertions.assertLinesMatch(expectedWords,actualWords);*/
        int A[]={1,2,3};
        Assertions.assertTimeout(Duration.ofSeconds(1),()->sortAnArray(A));

    }

    public int [] sortAnArray(int[] A) throws InterruptedException {
       // Thread.sleep(2000);
        return A;
    }
}
