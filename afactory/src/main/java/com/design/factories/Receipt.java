package com.design.factories;

import com.design.models.KFCChicken;
import com.design.models.JLBChicken;
import org.springframework.stereotype.Component;

@Component
public interface Receipt {
    String fry();
    String makeKebab();

}
