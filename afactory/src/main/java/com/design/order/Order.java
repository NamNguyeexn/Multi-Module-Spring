package com.design.order;

import com.design.factories.Receipt;
import com.design.models.Beef;
import com.design.models.Chicken;
import org.springframework.stereotype.Component;

@Component
public class Order {
    private String beef;
    private String chicken;

    public String makingOrder(Receipt receipt){
        beef = receipt.makeKebab();
        chicken = receipt.fry();
        return beef + "\n" + chicken;
    }
}
