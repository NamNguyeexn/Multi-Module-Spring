package com.design.factories;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ReceiptManager {
    public static final String KFC_STORE = "KFC";
    public static final String JLB_STORE = "JLB";
    private final List<Receipt> receipts;

    public ReceiptManager(List<Receipt> receipts) {
        this.receipts = receipts;
    }
    public Receipt getInstance(String type) throws Exception {
        String tp = type.toUpperCase();
        if (tp.contains(JLB_STORE)){
            return receipts.stream()
                    .filter(factory -> factory.getClass().getName().equalsIgnoreCase(JLBReceipt.class.getName()))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Cant find factory"));
        } else if (tp.contains(KFC_STORE)){
            return receipts.stream()
                    .filter(factory -> factory.getClass().getName().equalsIgnoreCase(KFCReceipt.class.getName()))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Cant find factory"));
        } throw new Exception("Cant find factory");
    }
}
