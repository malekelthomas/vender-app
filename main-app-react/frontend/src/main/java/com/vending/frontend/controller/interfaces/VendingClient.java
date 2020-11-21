package com.vending.frontend.controller.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.vending.frontend.models.VendingMachineDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("vending-machine")
public interface VendingClient {
    
    @GetMapping("/vendingmachines")
    Map<String, ArrayList<VendingMachineDTO>> getAll();

    @GetMapping("/vendingmachines/{id}")
    VendingMachineDTO getOne(@PathVariable Integer id);

}
