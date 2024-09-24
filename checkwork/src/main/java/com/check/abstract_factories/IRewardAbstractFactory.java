package com.check.abstract_factories;

import org.springframework.stereotype.Component;

@Component
public interface IRewardAbstractFactory {
    <T> T newChange(Class<T> typeClass, String name, long money);
}
