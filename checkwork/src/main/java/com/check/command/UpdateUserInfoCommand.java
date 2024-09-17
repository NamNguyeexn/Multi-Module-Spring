package com.check.command;

import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.command.handlers.ValidateEmail;
import com.check.command.handlers.ValidateUsername;
import com.check.command.handlers.ValidatorChain;
import com.check.mapper.UserMapper;
import com.check.models.User;
import com.check.repositories.JPARepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class UpdateUserInfoCommand implements Command{
    private final List<User> userChangeInfo = new ArrayList<>();
    private final UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public UpdateUserInfoCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(ChangeInfoInputDTO changeInfoInputDTO, User user) {
        Optional<User> oldInfo = userRepository.findById(user.getId());
        if(oldInfo.isEmpty()) {
            return false;
        }
        ValidatorChain chain = new ValidatorChain()
                .setHandle(new ValidateUsername(userRepository))
                .setHandle(new ValidateEmail(userRepository));
        chain.doHandle(changeInfoInputDTO);
        if(!changeInfoInputDTO.getMessageStr().isEmpty()) return false;
        //pass all validator
        userChangeInfo.add(oldInfo.get());
        int humanid = oldInfo.get().getHumanid();
        String employeeCode = oldInfo.get().getEmployeeCode();
        User newUser = userMapper.changeInfoToUser(humanid, employeeCode, changeInfoInputDTO);
        userRepository.save(newUser);
        return true;
    }

    @Override
    public boolean undo(User user) {
        if(userChangeInfo.contains(user)){
            userRepository.save(user);
            return true;
        } else return false;
    }
}
