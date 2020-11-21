package com.vendingmachines.vms.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class VendingMachine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String owner;
    
 
    @ElementCollection
    private Map<String,Integer> inventory; //Product IDs(inventory_key in DB), Quantity(inventory in DB)




    public VendingMachine(){

    }
    
    public VendingMachine(Integer id, String owner){
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
