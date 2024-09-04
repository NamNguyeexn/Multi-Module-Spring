package com.check.abstract_factories.models;

import lombok.Builder;

public class MinusLate extends IMinus {
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
