package com.check.command;

import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public interface Command {
    boolean execute(ChangeInfoInputDTO changeInfoInputDTO, User user);
    boolean undo(User user);
}
