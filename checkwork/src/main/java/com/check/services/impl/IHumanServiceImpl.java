package com.check.services.impl;

import com.check.models.Human;
import com.check.repositories.JPARepository.HumanRepository;
import com.check.services.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.check.repositories.JPARepository.HumanRepository.Specs.byId;

@Service
public class IHumanServiceImpl implements IHumanService {
    @Autowired
    private HumanRepository humanRepository;
    @Override
    public Optional<Human> getHumanById(int id) {
        return humanRepository.findOne(byId(id));
    }

    @Override
    public void saveNewHuman(Human human) {
        humanRepository.save(human);
    }
}
