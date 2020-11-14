package com.vinivender.vending.product;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    @RequestMapping("/products")
    public Map<String, Product[]> getAllProducts(){
        Map<String, Product[]> productsData = new HashMap<String, Product[]>();
        Product[] products = {new Product("1","Doritos","$1.00","Nacho Cheese"), new Product("2","Doritos","$1.00","Cool Ranch")}; 
        productsData.put("data", products);

        return productsData;        
    }
    
}
