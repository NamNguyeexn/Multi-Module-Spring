package com.check.services;

import com.check.dto.RegisterFormInput;
import com.check.command.ICommand;
import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.models.Human;
import com.check.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    Optional<Human> getHumanByUsername(String username);
    Optional<User> getUserById(int id);
    Optional<User> getUserByUsername(String username);
    /**
     * Su dung trong controller de luu thong tin user lay ra tu form dang ky
     * */
    Optional<User> saveNewUser(RegisterFormInput registerFormInput);
    Optional<Human> getHumanByPhone(String phone);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByEmployeeCode(String employeeCode);
    /**
     * Su dung trong command, de luu thong tin user khi cap nhat thong tin user
     * */
    void setCommand(ICommand command);
    boolean executeCommand(ChangeInfoInputDTO changeInfoInputDTO, User user);
    boolean undoCommand(User user);
}
