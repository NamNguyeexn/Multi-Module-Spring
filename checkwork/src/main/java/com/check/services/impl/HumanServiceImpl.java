package com.check.services.impl;

import com.check.models.Human;
import com.check.models.User;
import com.check.repositories.CustomHumanRepository;
import com.check.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HumanServiceImpl implements HumanService {
    @Autowired
    private CustomHumanRepository customHumanRepository;
    @Override
    public Optional<Human> getHumanById(int id) {
        return customHumanRepository.getHumanById(id);
    }

    @Override
    public Optional<Human> saveNewHuman(Human human) {
        customHumanRepository.saveHuman(human);
        return Optional.empty();
    }
}
