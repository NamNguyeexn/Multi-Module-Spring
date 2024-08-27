package com.design.factories;

import com.design.models.KFCBeef;
import com.design.models.KFCChicken;
import org.springframework.stereotype.Service;

@Service
public class KFCReceipt implements Receipt {
    @Override
    public String fry() {
        KFCChicken chicken = new KFCChicken();
        return chicken.fry();
    }

    @Override
    public String makeKebab() {
        KFCBeef beef = new KFCBeef();
        return beef.makeKebab();
    }
}
