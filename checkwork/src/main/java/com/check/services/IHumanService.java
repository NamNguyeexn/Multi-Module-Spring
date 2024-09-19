package com.check.services;

import com.check.models.Human;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Primary
public interface IHumanService {
    Optional<Human> getHumanById(int id);
    void saveNewHuman(Human human);
}
