package com.check.batch.steps.readers;

import com.check.batch.DTO.WorkHourBatch;
import com.check.batch.steps.filters.PerEvaluationQueryProvider;
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
public class WorkHourReader {
    @Autowired
    private PerEvaluationQueryProvider perEvaluationQueryProvider;
    @Autowired
    private DataSource dataSource;
    @Bean
    public JdbcPagingItemReader<WorkHourBatch> getReader() throws Exception {
        SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = perEvaluationQueryProvider.getQueryProvider();
        PagingQueryProvider queryProvider = queryProviderFactoryBean.getObject();
        assert queryProvider != null;
        return new JdbcPagingItemReaderBuilder<WorkHourBatch>()
                .name("pagingUserReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<>(WorkHourBatch.class))
                .pageSize(1000)
                .build();
    }
}
