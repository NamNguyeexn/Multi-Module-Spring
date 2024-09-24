package com.check.composites.visitor;

import com.check.composites.models.Category;
import com.check.composites.models.Product;

public class IVisitorImpl implements IVisitor{
    @Override
    public void visit(Category category) {
        System.out.println("This is visitor from Category");
        category.categorySetName();
    }

    @Override
    public void visit(Product product) {
        System.out.println("This is visitor from Product");
        product.productSetName();
    }
}
