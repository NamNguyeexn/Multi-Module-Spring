package com.check.abstract_factories.factories;

import com.check.abstract_factories.RewardAbstractFactory;
import com.check.abstract_factories.models.*;
import org.springframework.stereotype.Component;

@Component
public class IMinusFactory implements RewardAbstractFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        return switch (typeClass.getName()) {
            case "com.check.abstract_factories.models.MinusLate" -> (T) new MinusLate(name, money);
            case "com.check.abstract_factories.models.MinusPunish" -> (T) new MinusPunish(name, money);
            default -> throw new IllegalArgumentException("Unsupported typeClass: " + typeClass.getName());
        };
    }
}
