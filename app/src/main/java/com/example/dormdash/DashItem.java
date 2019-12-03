package com.example.dormdash;

public class DashItem {
    private double price;
    private String name;
    public DashItem(String setName, double setPrice) {
        price = setPrice;
        name = setName;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
