package com.check.composites.models;

import java.util.ArrayList;
import java.util.List;

public class Category extends ProductComponent{
    private final String name;
    private final List<ProductComponent> productComponents = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
    public void add(ProductComponent component){
        productComponents.add(component);
    }
    public void remove(ProductComponent component){
        productComponents.remove(component);
    }
    @Override
    public void display() {
        System.out.println("Big Category : " + name);
        for (ProductComponent component : productComponents){
            component.display();
        }
    }
}