package com.design.configs;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;

import javax.sql.DataSource;

public class MySQLDataSourceFactory implements DataSourceFactory{

    @Override
    public DataSource createDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/qlynhansu");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("123456aA@");
        return dataSourceBuilder.build();
    }
}
