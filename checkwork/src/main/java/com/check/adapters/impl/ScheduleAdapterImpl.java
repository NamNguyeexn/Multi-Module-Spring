package com.check.adapters.impl;

import com.check.adapters.IScheduleAdapter;
import com.check.models.Human;
import com.check.services.IAppointmentService;
import com.check.services.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Primary
public class ScheduleAdapterImpl implements IScheduleAdapter {
    @Autowired
    private IHumanService humanService;
    @Override
    public String toHostname(int hostid) {
        return humanService.getHumanById(hostid).get().getName();
    }

    @Override
    public String toJoinsname(String input) {
        List<String> number = new ArrayList<>();
        for (Character c : input.toCharArray()){
            if (Character.isDigit(c)) number.add(c + "");
        }
        String[] joinid = number.toArray(new String[0]);
        List<String> res = new ArrayList<>();
        for(String s : joinid){
            Optional<Human> human = humanService.getHumanById(Integer.parseInt(s));
            //xu ly join id
            if(human.isEmpty()) continue;
            //
            res.add(human.get().getName());
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < res.size(); i++){
            builder.append(res.get(i));
            if (i != res.size() - 1) {
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
