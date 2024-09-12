package com.check.composites;

import com.check.composites.models.Category;
import com.check.composites.models.Product;

public class CompositeMain {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        Category category1 = new Category("Category 1");
        Category category2 = new Category("Category 2");

        category1.add(product1);
        category1.add(product2);
        category2.add(product3);

        Category mainCategory = new Category("Main Category");
        mainCategory.add(category1);
        mainCategory.add(category2);

        mainCategory.display();
    }
}
