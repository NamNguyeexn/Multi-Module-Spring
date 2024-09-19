package com.check.composites.models;

public class Product extends ProductComponent{
    private final String name;
    public Product(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void display() {
        System.out.println("Product : " + name);
    }
}
