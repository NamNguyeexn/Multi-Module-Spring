package com.check.abstract_factories.factories;

import com.check.abstract_factories.RewardAbstractFactory;
import com.check.abstract_factories.models.BonusReward;
import com.check.abstract_factories.models.MinusPunish;
import org.springframework.stereotype.Component;

@Component
public class RewardAbstractFactoryImpl implements RewardAbstractFactory {
    private final IMinusFactory iMinusFactory = new IMinusFactory();
    private final IBonusFactory iBonusFactory = new IBonusFactory();
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        return MinusPunish.class.isAssignableFrom(typeClass)
                ? iMinusFactory.newChange(typeClass, name, money)
                : iBonusFactory.newChange(typeClass, name, money);
    }
}
