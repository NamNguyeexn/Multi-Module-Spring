package com.check.abstract_factories.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IMinus {
    private String name;
    private long minus;

    public abstract String getReason();
    public abstract String getValue(long minus);
    public abstract String getName(String name);
}
