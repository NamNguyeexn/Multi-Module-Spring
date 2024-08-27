package com.check.adapters;

import com.check.models.Human;
import com.check.repositories.CustomHumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Component
public class HumanAdapter implements HumanInformation{
    @Autowired
    private CustomHumanRepository humanRepository;
    @Override
    public Optional<Human> getHumanById(int id) {
        return humanRepository.getHumanById(id);
    }

    @Override
    public Optional<Human> getHumanByPhone(String phone) {
        return humanRepository.getHumanByPhone(phone);
    }

    @Transactional
    @Override
    public void saveNewHuman(Human human) {
        humanRepository.saveHuman(human);
    }

    @Override
    public void deleteHumanById(int id) {
        humanRepository.deleteHumanById(id);
    }

}
