package org.example;

public class Product {

    private String id;
    private String description;
    private double unitPrice;

    public Product(){

    }

    public Product(String id, String description,int unitPrice){
        this.id=id;
        this.description=description;
        this.unitPrice=unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
