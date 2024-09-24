package com.check.batch.steps.filters;

import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class UserStateQueryProvider {
    @Autowired
    private DataSource dataSource;
    @Bean
    public SqlPagingQueryProviderFactoryBean getQueryProvider() {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from user");
        queryProvider.setSortKey("id");
        return queryProvider;
    }
}
