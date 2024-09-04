package com.check.abstract_factories.models;


public class MinusPunish extends IMinus {
//    private String name;
//    private long minus;
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

    public MinusPunish(){}
}
