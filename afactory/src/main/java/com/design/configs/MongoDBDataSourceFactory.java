package com.design.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class MongoDBDataSourceFactory implements DataSourceFactory{
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String databaseName;
    @Override
    public DataSource createDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mongodb.driver");
        dataSourceBuilder.url(mongoUri);
        return dataSourceBuilder.build();
    }
}
