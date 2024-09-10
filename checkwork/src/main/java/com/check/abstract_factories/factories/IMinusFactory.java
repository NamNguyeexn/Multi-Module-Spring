package com.check.abstract_factories.factories;

import com.check.abstract_factories.RewardAbstractFactory;
import com.check.abstract_factories.models.IMinus;
import com.check.abstract_factories.models.MinusLate;
import com.check.abstract_factories.models.MinusPunish;

public class IMinusFactory implements RewardAbstractFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T newChange(Class<T> typeClass, String name, long money) {
        final IMinus iMinus = typeClass.equals(MinusPunish.class)
                ? new MinusPunish()
                : new MinusLate();
        iMinus.setName(name);
        iMinus.setMinus(money);
        return (T) iMinus;
    }
}
