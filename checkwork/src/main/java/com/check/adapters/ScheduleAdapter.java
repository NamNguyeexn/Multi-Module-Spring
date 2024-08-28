package com.check.adapters;

import org.springframework.stereotype.Component;

@Component
public interface ScheduleAdapter {
    String toHostname(int hostid);
    String toJoinsname(String[] joinid);
}
