package com.check.adapters.impl;

import com.check.adapters.ScheduleAdapter;
import com.check.services.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleAdapterImpl implements ScheduleAdapter {
    @Autowired
    private IHumanService humanService;
    @Override
    public String toHostname(int hostid) {
        return humanService.getHumanById(hostid).get().getName();
    }

    @Override
    public String toJoinsname(String[] joinid) {
        return "";
    }
}
