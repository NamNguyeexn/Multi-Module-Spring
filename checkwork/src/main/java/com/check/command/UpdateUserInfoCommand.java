package com.check.command;

import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.command.handlers.ValidateEmail;
import com.check.command.handlers.ValidateUsername;
import com.check.command.handlers.ValidatorChain;
import com.check.models.ENUM.Department;
import com.check.models.ENUM.Role;
import com.check.models.User;
import com.check.repositories.JPARepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.check.repositories.JPARepository.UserRepository.Specs.byUsername;

@Component
@Primary
public class UpdateUserInfoCommand implements ICommand {
    private final Map<Integer, User> userChangeInfo = new HashMap<>();
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UpdateUserInfoCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(ChangeInfoInputDTO changeInfoInputDTO, User user) {
        Optional<User> oldInfo = userRepository.findById(user.getId());
        if (oldInfo.isEmpty()) {
            return false;
        }
        ValidatorChain chain = new ValidatorChain()
                .setHandle(new ValidateUsername(userRepository))
                .setHandle(new ValidateEmail(userRepository));
        chain.doHandle(changeInfoInputDTO);

        changeInfoInputDTO.setMessageStr("");
        if (!changeInfoInputDTO.getMessageStr().isEmpty()) return false;
        //pass all validator
        userChangeInfo.put(oldInfo.get().getId(), oldInfo.get());
        int humanid = oldInfo.get().getHumanid();
        String employeeCode = oldInfo.get().getEmployeeCode();

        String password = passwordEncoder.encode(changeInfoInputDTO.getPassword());

        User newUser = User.builder()
                .humanid(humanid)
                .employeeCode(employeeCode)
                .email(changeInfoInputDTO.getEmail())
                .username(changeInfoInputDTO.getUsername())
                .password(password)
                .role(Role.valueOf(changeInfoInputDTO.getRole()))
                .department(Department.valueOf(changeInfoInputDTO.getDepartment()))
                .build();
        newUser.setId(user.getId());
        userRepository.save(newUser);
        return true;
    }

    @Override
    public boolean undo(User user) {
        if (userChangeInfo.containsKey(user.getId())) {
            User oldUser = userChangeInfo.get(user.getId());
            Optional<User> newUser = userRepository.findOne(byUsername(user.getUsername()));
            newUser.get().setHumanid(oldUser.getHumanid());
            newUser.get().setEmployeeCode(oldUser.getEmployeeCode());
            newUser.get().setEmail(oldUser.getEmail());
            newUser.get().setUsername(oldUser.getUsername());
            newUser.get().setPassword(oldUser.getPassword());
            newUser.get().setRole(oldUser.getRole());
            newUser.get().setDepartment(oldUser.getDepartment());
            userRepository.save(newUser.get());
            return true;
        } else return false;
    }
}
