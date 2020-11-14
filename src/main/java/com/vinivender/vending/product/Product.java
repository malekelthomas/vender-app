package com.vinivender.vending.product;

public class Product {

    private String id;
    private String productName;
    private String price;
    private String description;

    public Product(){

    }

    public Product(String id, String productName, String price, String description) {
        super();
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




    
    
}
