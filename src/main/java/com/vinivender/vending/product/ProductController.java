package com.vinivender.vending.product;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public Map<String, Product[]> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id){
        return this.productService.getProduct(id);
    }
    
}
