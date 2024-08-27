package com.design.models;

import com.design.factories.Receipt;

public class Client {
    private Receipt receipt;

    public Client(Receipt receipt) {
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

}
