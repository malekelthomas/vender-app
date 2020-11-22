package com.vending.frontend.controller;

import java.util.ArrayList;
import java.util.Map;

import com.vending.frontend.controller.interfaces.VendingClient;
import com.vending.frontend.models.ProductDTO;
import com.vending.frontend.models.VendingMachineDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
@RequestMapping("/vendingmachines")
public class VendingController {

    @Autowired
    private VendingClient vendingClient;

    @GetMapping("/")
    public Map<String, ArrayList<VendingMachineDTO>> getAll(){
        return this.vendingClient.getAll();
    }
    
    @PostMapping("/")
    public void registerVendingMachine(@RequestBody VendingMachineDTO vm){
        this.vendingClient.registerVendingMachine(vm);
    }
    
    @GetMapping("/{id}")
    public VendingMachineDTO getOne(@PathVariable Integer id){
        return this.vendingClient.getOne(id);
    }


    @PostMapping("/{id}/inventory/add/{quantity}")
    public void addProductToInventory(@RequestBody ProductDTO product, @PathVariable Integer quantity, @PathVariable Integer id){
        this.vendingClient.addProductToInventory(product, quantity, id);
    }
    
}
