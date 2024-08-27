package com.design.controllers;

import com.design.factories.JLBReceipt;
import com.design.factories.KFCReceipt;
import com.design.factories.Receipt;
import com.design.factories.ReceiptManager;
import com.design.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private ConfigurableApplicationContext context;
    @GetMapping("")
    public ResponseEntity<String> getFoods(@RequestBody String orderStr) throws Exception {
        Order order = context.getBean(Order.class);
        ReceiptManager receiptManager = context.getBean(ReceiptManager.class);
        Receipt receipt = receiptManager.getInstance(orderStr);
        return ResponseEntity.ok().body("TIME: " + LocalDateTime.now() + "\n" + order.makingOrder(receipt));
    }
}
