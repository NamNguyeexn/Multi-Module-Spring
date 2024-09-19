package com.check.abstract_factories.models;

import org.springframework.stereotype.Component;

@Component
public class MinusPunish extends IMinus {
    public MinusPunish() {
    }

    @Override
    public String getReason() {
        return "You made a mistake!";
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

    public MinusPunish(String name, long minus){
        this.setName(name);
        this.setMinus(minus);
    }
}
