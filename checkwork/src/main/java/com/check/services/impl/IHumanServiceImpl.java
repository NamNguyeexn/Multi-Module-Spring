package com.check.services.impl;

import com.check.models.Human;
import com.check.repositories.CustomHumanRepository;
import com.check.services.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IHumanServiceImpl implements IHumanService {
    @Autowired
    private CustomHumanRepository customHumanRepository;
    @Override
    public Optional<Human> getHumanById(int id) {
        return customHumanRepository.getHumanById(id);
    }

    @Override
    public void saveNewHuman(Human human) {
        customHumanRepository.saveHuman(human);
    }
}
