package com.vending.frontend.controller.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.vending.frontend.models.ProductDTO;
import com.vending.frontend.models.VendingMachineDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("vending-machine")
public interface VendingClient {
    
    @GetMapping("/vendingmachines")
    Map<String, ArrayList<VendingMachineDTO>> getAll();

    @GetMapping("/vendingmachines/{id}")
    VendingMachineDTO getOne(@PathVariable Integer id);

    @PostMapping("/vendingmachines")
    void registerVendingMachine(@RequestBody VendingMachineDTO vm);

    @PostMapping("/vendingmachines/{id}/inventory/add/{quantity}")
    void addProductToInventory(@RequestBody ProductDTO product, @PathVariable Integer quantity, @PathVariable Integer id);

}
