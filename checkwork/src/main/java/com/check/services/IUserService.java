package com.check.services;

import com.check.DTO.RegisterFormInput;
import com.check.models.Human;
import com.check.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    Optional<Human> getHumanByUsername(String username);
    Optional<User> getUserByUsername(String username);
    Optional<User> saveNewUser(RegisterFormInput registerFormInput);
    Optional<Human> getHumanByPhone(String phone);
    Optional<User> getUserByEmail(String email);
}
