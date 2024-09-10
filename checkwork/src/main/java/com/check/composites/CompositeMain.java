package com.check.composites;

import com.check.composites.models.Category;
import com.check.composites.models.Product;

public class CompositeMain {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop");
        Product product2 = new Product("Smartphone");
        Product product3 = new Product("Tablet");

        Category electronics = new Category("Electronics");
        Category computers = new Category("Computers");

        electronics.add(product1);
        electronics.add(product2);
        computers.add(product3);

        Category mainCategory = new Category("Store");
        mainCategory.add(electronics);
        mainCategory.add(computers);

        mainCategory.display();
    }
}
