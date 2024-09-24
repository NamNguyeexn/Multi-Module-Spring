package com.check.batch.steps.processors;

import com.check.models.User;
import com.check.models.UserState;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserStateProcessor implements ItemProcessor<User, UserState> {
    @Override
    public UserState process(User item) throws Exception {
        return UserState.builder()
                .userid(item.getId())
                .build();
    }
}
