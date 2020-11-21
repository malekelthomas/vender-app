package com.vending.frontend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;





public class VendingMachineDTO {
    
    private Integer id;
    private String owner;
    
 
    private Map<String,Integer> inventory; //Product IDs(inventory_key in DB), Quantity(inventory in DB)




    public VendingMachineDTO(){

    }
    
    public VendingMachineDTO(Integer id, String owner){
        super();
        this.id = id;
        this.owner = owner;

    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Map<String,Integer> getInventory() {
        return this.inventory;
    }

    public void addToInventory(String productId, Integer quantity) {
        if(this.inventory.containsKey(productId)){
            Integer newQuantity = this.inventory.get(productId)+quantity;
            this.inventory.put(productId, newQuantity);
        }
        else{
            this.inventory.put(productId, quantity);
        }
    }

}
