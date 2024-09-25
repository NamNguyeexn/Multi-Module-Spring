package com.check.batch.steps.readers;

import com.check.batch.steps.filters.UserStateQueryProvider;
import com.check.models.User;
import com.check.repositories.JPARepository.UserRepository;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserReader {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserStateQueryProvider queryProvider;
    @Autowired
    private UserRepository userRepository;
    public RepositoryItemReader<User> getReader() {
        RepositoryItemReader<User> reader = new RepositoryItemReader<>();
        reader.setRepository(userRepository);
        reader.setMethodName("findAll");
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }
}
