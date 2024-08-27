package com.design.factories;

import com.design.models.Chicken;
import com.design.models.JLBBeef;
import com.design.models.KFCChicken;
import com.design.models.JLBChicken;
import org.springframework.stereotype.Service;

@Service
public class JLBReceipt implements Receipt{
    @Override
    public String fry() {
        JLBChicken chicken = new JLBChicken();
        return chicken.fry();
    }

    @Override
    public String makeKebab() {
        JLBBeef beef = new JLBBeef();
        return beef.makeKebab();
    }
}
