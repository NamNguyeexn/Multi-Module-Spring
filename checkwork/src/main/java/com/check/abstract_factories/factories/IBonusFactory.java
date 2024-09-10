package com.check.abstract_factories.factories;

import com.check.abstract_factories.RewardAbstractFactory;
import com.check.abstract_factories.models.BonusBirthday;
//import com.check.abstract_factories.models.BonusHoliday;
import com.check.abstract_factories.models.BonusReward;
import com.check.abstract_factories.models.IBonus;

public class IBonusFactory implements RewardAbstractFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        final IBonus iBonus = typeClass.equals(BonusBirthday.class)
                ? new BonusBirthday()
                : new BonusReward();
        iBonus.setName(name);
        iBonus.setBonus(money);
        return (T) iBonus;
    }
}
