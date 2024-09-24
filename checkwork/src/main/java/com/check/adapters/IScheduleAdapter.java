package com.check.adapters;

import org.springframework.stereotype.Component;


@Component
public interface IScheduleAdapter {
    String toHostname(int hostid);
    String toJoinsname(String joinid);
}
