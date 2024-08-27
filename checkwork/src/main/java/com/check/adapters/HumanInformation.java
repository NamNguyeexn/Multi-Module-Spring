package com.check.adapters;

import com.check.models.Human;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;

@Component
public interface HumanInformation {
    Optional<Human> getHumanById(int id);
    Optional<Human> getHumanByPhone(String phone);
    void saveNewHuman(Human human);
    void deleteHumanById(int id);
}
