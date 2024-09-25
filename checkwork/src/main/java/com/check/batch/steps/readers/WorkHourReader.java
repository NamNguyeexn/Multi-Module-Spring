package com.check.batch.steps.readers;

import com.check.batch.DTO.WorkHourBatch;
import com.check.batch.steps.filters.PerEvaluationQueryProvider;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.repositories.JPARepository.WorkHourRepository;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class WorkHourReader {
    @Autowired
    private PerEvaluationQueryProvider perEvaluationQueryProvider;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private WorkHourRepository workHourRepository;
    public RepositoryItemReader<WorkHour> getReader() {
        RepositoryItemReader<WorkHour> reader = new RepositoryItemReader<>();
        reader.setRepository(workHourRepository);
        reader.setMethodName("findAll");
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }
}
