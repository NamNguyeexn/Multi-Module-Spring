package com.check.composites.visitor;

import com.check.composites.models.Category;
import com.check.composites.models.Product;

import java.awt.*;

public interface IVisitor {
    void visit(Category category);
    void visit(Product product);
}
