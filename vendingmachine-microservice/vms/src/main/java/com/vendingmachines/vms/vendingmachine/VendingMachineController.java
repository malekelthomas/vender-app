package com.vendingmachines.vms.vendingmachine;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingMachineController {
    
    @Autowired
    private VendingMachineService vmService;

    @GetMapping("/vendingmachines")
    public Map<String, ArrayList<VendingMachine>> getAllVendingMachines(){
        return this.vmService.getAllVendingMachines();
    }
    
    @GetMapping("/vendingmachines/{id}")
    public VendingMachine getVendingMachine(@PathVariable Integer id){
        return this.vmService.getVendingMachine(id);
    }

    @PostMapping("/vendingmachines")
    public void registerVendingMachine(@RequestBody VendingMachineDTO vm){
        VendingMachine persistentVM = new VendingMachine();
        persistentVM.setId(vm.getId());
        persistentVM.setOwner(vm.getOwner());
        this.vmService.registerVendingMachine(persistentVM);
    }

    @PostMapping("/vendingmachines/{id}/inventory/add/{quantity}")
    public void addProductToInventory(@RequestBody ProductDTO product, @PathVariable Integer quantity, @PathVariable Integer id){
        /* Product persistentProduct = new Product();
        persistentProduct.setId(product.getId());
        persistentProduct.setProductName(product.getProductName());
        persistentProduct.setPrice(product.getPrice());
        persistentProduct.setDescription(product.getDescription()); */
        String productId = Integer.toString(product.getId());
        this.vmService.addProductToInventory(id, productId, quantity);
    }
}
