package com.check.abstract_factories.models;

import org.springframework.stereotype.Component;

@Component
public class MinusLate extends Minus {
    public MinusLate(String name, long money) {
        this.setName(name);
        this.setMinus(money);
    }

    @Override
    public String getReason() {
        return "You have been late!";
    }

    @Override
    public String getValue(long minus) {
//        this.minus = minus;
        return String.valueOf(minus);
    }

    @Override
    public String getName(String name) {
//        this.name = name;
        return name;
    }
    public MinusLate(){}
}
