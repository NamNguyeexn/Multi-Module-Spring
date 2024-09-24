package com.check.batch.steps.writers;

import com.check.models.UserState;
import com.check.repositories.JPARepository.UserStateRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserStateWriter {
    @Autowired
    private UserStateRepository userStateRepository;
    @Bean
    public RepositoryItemWriter<UserState> getWriter(){
        RepositoryItemWriter<UserState> writer = new RepositoryItemWriter<>();
        writer.setRepository(userStateRepository);
        writer.setMethodName("save");
        return writer;
    }
}
