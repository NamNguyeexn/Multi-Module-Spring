package com.check.composites.models;

public abstract class ProductComponent {
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public void add(ProductComponent productComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(ProductComponent component) {
        throw new UnsupportedOperationException();
    }
    public abstract void display();
}
