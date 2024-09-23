package com.check.composites.models;

import com.check.composites.visitor.Visitor;
import lombok.Setter;


public class Product extends ProductComponent{
    private String name;
    public void productSetName() {
        name = name.toLowerCase();
    }
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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
