package com.vendingmachines.vms.vendingmachine;

import java.util.ArrayList;


public class VendingMachineDTO {
    
    private Integer id;
    private String owner;
    private ArrayList<Product> inventory;




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

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void addToInventory(Product product) {
        this.inventory.add(product);
    }

}
