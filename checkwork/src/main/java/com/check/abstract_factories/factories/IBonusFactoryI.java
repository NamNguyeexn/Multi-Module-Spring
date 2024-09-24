package com.check.abstract_factories.factories;

import com.check.abstract_factories.IRewardAbstractFactory;
import com.check.abstract_factories.models.BonusBirthday;
//import com.check.abstract_factories.models.BonusHoliday;
import com.check.abstract_factories.models.BonusReward;
import org.springframework.stereotype.Component;

@Component
public class IBonusFactoryI implements IRewardAbstractFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        return switch (typeClass.getName()) {
            case "com.check.abstract_factories.models.BonusBirthday" -> (T) new BonusBirthday(name, money);
            case "com.check.abstract_factories.models.BonusReward" -> (T) new BonusReward(name, money);
            default -> throw new IllegalArgumentException("Unsupported typeClass: " + typeClass.getName());
        };
    }
}
