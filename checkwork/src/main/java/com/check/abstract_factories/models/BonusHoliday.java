package com.check.abstract_factories.models;

import lombok.Builder;

public class BonusHoliday extends IBonus {
//    private String name;
//    private long bonus;

    @Override
    public String getReason() {
        return "Its your holiday";
    }

    @Override
    public String getBonus(long bonus) {
//        this.bonus = bonus;
        return String.valueOf(bonus);
    }

    @Override
    public String getName(String name) {
//        this.name = name;
        return name;
    }

    public BonusHoliday(){}
}
