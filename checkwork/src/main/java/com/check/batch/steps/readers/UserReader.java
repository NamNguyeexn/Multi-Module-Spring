package com.check.batch.steps.readers;

import com.check.batch.steps.filters.UserStateQueryProvider;
import com.check.batch.steps.processors.UserStateProcessor;
import com.check.models.User;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserReader {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserStateQueryProvider queryProvider;
    @Bean
    public JdbcPagingItemReader<User> getReader() throws Exception {
        SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = queryProvider.getQueryProvider();
        PagingQueryProvider queryProvider = queryProviderFactoryBean.getObject();
        assert queryProvider != null;
        return new JdbcPagingItemReaderBuilder<User>()
                .name("pagingUserReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<>(User.class))
                .pageSize(1000)
                .build();
    }
}
