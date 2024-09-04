package com.check.abstract_factories.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IMinus {
    private String name;
    private long minus;

    abstract String getReason();
    abstract String getValue(long minus);
    abstract String getName(String name);
}
