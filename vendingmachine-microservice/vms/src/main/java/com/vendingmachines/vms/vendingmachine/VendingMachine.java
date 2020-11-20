package com.vendingmachines.vms.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VendingMachine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String owner;
    
    @ElementCollection
    private List<Integer> inventory; //Product IDs




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

    public List<Integer> getInventory() {
        return this.inventory;
    }

    public void addToInventory(Integer productId) {
        this.inventory.add(productId);
    }

}
