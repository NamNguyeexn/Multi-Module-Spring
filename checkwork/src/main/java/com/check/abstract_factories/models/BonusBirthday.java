package com.check.abstract_factories.models;

import org.springframework.stereotype.Component;

@Component
public class BonusBirthday extends Bonus {
    public BonusBirthday(String name, long money) {
        this.setName(name);
        this.setBonus(money);
    }

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
