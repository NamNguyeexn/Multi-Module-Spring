package com.check.abstract_factories.factories;

import com.check.abstract_factories.IRewardAbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class IRewardAbstractFactoryImpl implements IRewardAbstractFactory {
    @Autowired
    private IMinusFactoryI iMinusFactory = new IMinusFactoryI();
    @Autowired
    private IBonusFactoryI iBonusFactory = new IBonusFactoryI();
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
