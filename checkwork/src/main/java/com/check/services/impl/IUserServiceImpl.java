package com.check.services.impl;

import com.check.DTO.RegisterFormInput;
import com.check.command.Command;
import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.mapper.HumanMapper;
import com.check.mapper.UserMapper;
import com.check.models.Human;
import com.check.models.ENUM.Role;
import com.check.models.User;
import com.check.repositories.CustomHumanRepository;
import com.check.repositories.JPARepository.UserRepository;
import com.check.services.IUserService;
import com.common.utils.ConvertData;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import static com.check.repositories.JPARepository.UserRepository.Specs.*;

@Service
@Slf4j
public class IUserServiceImpl implements IUserService {
    @Autowired
    private Command command;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomHumanRepository humanRepository;
    @Autowired
    private HumanMapper humanMapper;
    @Override
    public Optional<Human> getHumanByUsername(String username) {
        Optional<User> user = userRepository.findOne(byUsername(username));
        if (user.isEmpty()){
            return Optional.empty();
        } else {
            return humanRepository.getHumanById(user.get().getHumanid());
        }
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findOne(byId(id));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findOne(byUsername(username));
    }
    @Transactional(rollbackFor = NoResultException.class)
    @Override
    public Optional<User> saveNewUser(RegisterFormInput registerFormInput) {
        humanRepository.saveHuman(humanMapper.registerFormInputToHuman(registerFormInput, java.sql.Date.valueOf(registerFormInput.getDob())));
        Optional<Human> human = humanRepository.getHumanByPhone(registerFormInput.getPhone());
        try {
            if(human.isEmpty()){
                return Optional.empty();
            }
            String role = Role.USER.name();
            String employeeCode = ConvertData.convertEmployeeCode(role, String.valueOf(human.get().getId()));
            userRepository.save(userMapper.inputRegisterToUser(registerFormInput, human.get().getId(), role, employeeCode));
            return userRepository.findOne(byUsername(registerFormInput.getUsername()));
        } catch (NoResultException n){
            humanRepository.deleteHumanById(human.get().getId());
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Human> getHumanByPhone(String phone) {
        return humanRepository.getHumanByPhone(phone);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOne(byEmail(email));
    }

    @Override
    public Optional<User> getUserByEmployeeCode(String employeeCode) {
        return userRepository.findOne(byEmployeeCode(employeeCode));
    }

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean executeCommand(ChangeInfoInputDTO changeInfoInputDTO, User user) {
        return command.execute(changeInfoInputDTO, user);
    }

    @Override
    public boolean undoCommand(User user) {
        return command.undo(user);
    }
}

