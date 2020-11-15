package com.vinivender.vending.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    
    private Map<String, Product[]> Products(){
        Map<String, Product[]> productsData = new HashMap<String, Product[]>();
        Product[] products = {new Product("1","Doritos","$1.00","Nacho Cheese"), new Product("2","Doritos","$1.00","Cool Ranch")}; 
        {
            productsData.put("data", products);
        }
        return productsData;
    }

    public Map<String, Product[]> getAllProducts(){
        return Products();
    }

    public Product getProduct(String id){
        Product product = new Product();
        for(int i = 0; i <Products().get("data").length; i++){
            if(Products().get("data")[i].getId().equals(id)){
                product = Products().get("data")[i];
            }

        }
        return product;
    }
}
