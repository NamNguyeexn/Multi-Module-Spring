package com.check.abstract_factories;

public interface RewardAbstractFactory {
    <T> T newChange(Class<T> typeClass, String name, long money);
}
