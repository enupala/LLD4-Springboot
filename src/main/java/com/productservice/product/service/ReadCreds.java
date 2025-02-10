package com.productservice.product.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadCreds {
    public static void main(String[] args) throws FileNotFoundException {
        Properties props=new Properties();
        try(FileInputStream fis=new FileInputStream("C:\\Kalyani\\ecommerce\\Springboot\\src\\main\\java\\com\\productservice\\product\\service\\config\\config.properties")) {
            props.load(fis);
            String uname=props.getProperty("username");
            String pass=props.getProperty("password");
            System.out.println(uname+" "+pass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

    }
}
