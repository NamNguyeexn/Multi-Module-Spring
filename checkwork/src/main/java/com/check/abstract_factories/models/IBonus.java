package com.check.abstract_factories.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IBonus {
    private String name;
    private long bonus;

    public abstract String getReason();
    public abstract String getBonus(long bonus);
    public abstract String getName(String name);
}
