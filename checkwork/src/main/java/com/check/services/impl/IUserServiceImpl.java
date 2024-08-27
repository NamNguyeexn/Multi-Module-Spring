package com.check.services.impl;

import com.check.DTO.RegisterFormInput;
import com.check.adapters.HumanAdapter;
import com.check.mapper.HumanMapper;
import com.check.mapper.UserMapper;
import com.check.models.Human;
import com.check.models.ENUM.Role;
import com.check.models.User;
import com.check.repositories.CustomUserRepository;
import com.check.services.IUserService;
import com.common.utils.ConvertData;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class IUserServiceImpl implements IUserService {
    @Autowired
    private CustomUserRepository customUserRepository;
    @Autowired
    private UserMapper userMapper;
    private final HumanAdapter humanAdapter;
    public IUserServiceImpl(){
        this.humanAdapter = new HumanAdapter();
    }
    @Autowired
    private HumanMapper humanMapper;
    @Override
    public Optional<Human> getHumanByUsername(String username) {
        Optional<User> user = customUserRepository.getUserByUsername(username);
        if (user.isEmpty()){
            log.info("USER DAO - GET HUMAN BY USERNAME - NULL USER");
            return Optional.empty();
        } else {
            Optional<Human> human = humanAdapter.getHumanById(user.get().getHumanid());
            if (human.isEmpty()){
                log.info("USER DAO - GET HUMAN BY USERNAME - NULL HUMAN");
                return Optional.empty();
            } else {
                return human;
            }
        }
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return customUserRepository.getUserByUsername(username);
    }
    @Transactional(rollbackFor = NoResultException.class)
    @Override
    public Optional<User> saveNewUser(RegisterFormInput registerFormInput) {
        humanAdapter.saveNewHuman(humanMapper.registerFormInputToHuman(registerFormInput, java.sql.Date.valueOf(registerFormInput.getDob())));
        Optional<Human> human = humanAdapter.getHumanByPhone(registerFormInput.getPhone());
        try {
            if(human.isEmpty()){
                log.info("========================================");
                log.info("USER SERVICE - SAVE NEW USER - NOT FOUND HUMAN");
                return Optional.empty();
            }
            log.info("USER SERVICE - SAVE NEW USER - FOUND HUMAN");
            String role = Role.USER.name();
            String employeeCode = ConvertData.convertEmployeeCode(role, String.valueOf(human.get().getId()));
            customUserRepository.saveUser(userMapper.inputRegisterToUser(registerFormInput, human.get().getId(), role, employeeCode));
            log.info("USER SERVICE - SAVE NEW USER - SUCCESS");
            return customUserRepository.getUserByUsername(registerFormInput.getUsername());
        } catch (NoResultException n){
            log.info("USER SERVICE - SAVE NEW USER - EXCEPTION : {}", n.getMessage());
            humanAdapter.deleteHumanById(human.get().getId());
            return Optional.empty();
        } catch (Exception e) {
            log.info("USER SERVICE - SAVE NEW USER - EXCEPTION : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Human> getHumanByPhone(String phone) {
        return humanAdapter.getHumanByPhone(phone);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return customUserRepository.getUserByEmail(email);
    }
}

