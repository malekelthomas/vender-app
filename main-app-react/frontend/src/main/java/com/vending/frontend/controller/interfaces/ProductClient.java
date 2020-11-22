package com.vending.frontend.controller.interfaces;

import com.vending.frontend.models.ProductDTO;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("products")
public interface ProductClient {

    @GetMapping("/products")
    Map<String, ArrayList<ProductDTO>> getAll();

    @GetMapping("/products/{id}")
    ProductDTO getOne(@PathVariable Integer id);

    @PostMapping("/products")
    void addProduct(@RequestBody ProductDTO product);

    
}
