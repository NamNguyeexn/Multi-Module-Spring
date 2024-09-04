package com.check.abstract_factories.models;

import lombok.Builder;


public class BonusBirthday extends IBonus {
    @Override
    public String getReason() {
        return "Its Birthday";
    }

    @Override
    public String getBonus(long bonus) {
        return String.valueOf(bonus);
    }

    @Override
    public String getName(String name) {
        return name;
    }
    public BonusBirthday(){}
}
