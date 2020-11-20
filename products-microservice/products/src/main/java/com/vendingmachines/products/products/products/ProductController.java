package com.vendingmachines.products.products.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public Map<String, ArrayList<Product>> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable Integer id){
        return this.productService.getProduct(id);
    }
    @PostMapping("/products")
    @ResponseBody
    public void addProduct(@RequestBody ProductDTO product){
        Product persistentProduct = new Product();
        persistentProduct.setId(product.getId());
        persistentProduct.setProductName(product.getProductName());
        persistentProduct.setPrice(product.getPrice());
        persistentProduct.setDescription(product.getDescription());
        this.productService.addProduct(persistentProduct);
    }
    
}

