package com.vendingmachines.products.products.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    /**
     *
     */
    private static final String DATA = "data";
    @Autowired
    private ProductRepository productRepository;
    
    private static ArrayList<Product> products = new ArrayList<>();

    private static Map<String, ArrayList<Product>> productsData; 
    static {
        productsData = new HashMap<String, ArrayList<Product>>();
        productsData.put(DATA, products);
    }
        

    public Map<String, ArrayList<Product>> getAllProducts(){
        
        ArrayList<Product> products = new ArrayList<>();
        productRepository.findAll()
        .forEach(products::add); //load products from database and add to products ArrayList
        Map<String, ArrayList<Product>> productsData = new HashMap<String, ArrayList<Product>>(); //reinit HashMap, add new Data
        {
            productsData = new HashMap<String, ArrayList<Product>>();
            productsData.put(DATA, products);
        }
        return productsData;
    }

    public Product getProduct(Integer id){
        //return productsData.get(DATA).stream().filter(p -> p.getId().equals(id)).findFirst().get();
        Product product = productRepository.findById(id)
        .orElse(null);

        return product;
    }


    public void addProduct(Product product){
        productsData.computeIfAbsent(DATA, k -> new ArrayList<>()).add(product);
        productRepository.save(product);
        System.out.println(productsData.get(DATA));


    }
}
