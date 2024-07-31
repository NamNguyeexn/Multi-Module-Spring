package com.check.services;

import com.check.models.Human;
import com.check.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface HumanService {
    Optional<Human> getHumanById(int id);
    Optional<Human> saveNewHuman(Human human);
}
