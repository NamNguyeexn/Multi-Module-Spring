package com.check.abstract_factories.models;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class BonusReward extends IBonus {
    public BonusReward(String name, long money) {
        this.setName(name);
        this.setBonus(money);
    }

    @Override
    public String getReason() {
        return "Congrats! Its your reward";
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

    public BonusReward(){}
}
