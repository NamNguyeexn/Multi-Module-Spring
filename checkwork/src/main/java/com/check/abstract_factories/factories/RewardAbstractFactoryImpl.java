package com.check.abstract_factories.factories;

import com.check.abstract_factories.RewardAbstractFactory;
import com.check.abstract_factories.models.BonusBirthday;
import com.check.abstract_factories.models.BonusReward;
import com.check.abstract_factories.models.MinusLate;
import com.check.abstract_factories.models.MinusPunish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RewardAbstractFactoryImpl implements RewardAbstractFactory {
    @Autowired
    private IMinusFactory iMinusFactory = new IMinusFactory();
    @Autowired
    private IBonusFactory iBonusFactory = new IBonusFactory();
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        return switch (typeClass.getName()) {
            case "com.check.abstract_factories.models.BonusBirthday",
                 "com.check.abstract_factories.models.BonusReward"
                    -> iBonusFactory.newChange(typeClass, name, money);
            case "com.check.abstract_factories.models.MinusPunish",
                 "com.check.abstract_factories.models.MinusLate"
                    -> iMinusFactory.newChange(typeClass, name, money);
            default
                    -> throw new IllegalArgumentException("Unsupported typeClass: " + typeClass.getName());
        };
    }
}
