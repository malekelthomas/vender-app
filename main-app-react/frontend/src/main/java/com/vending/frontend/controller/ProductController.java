package com.vending.frontend.controller;

import java.util.ArrayList;
import java.util.Map;

import com.vending.frontend.controller.interfaces.ProductClient;
import com.vending.frontend.models.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/")
    public Map<String, ArrayList<ProductDTO>> getAll(){
        return this.productClient.getAll();
    }
    
}
