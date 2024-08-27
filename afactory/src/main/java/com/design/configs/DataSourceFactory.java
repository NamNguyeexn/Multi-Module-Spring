package com.design.configs;

import javax.sql.DataSource;

public interface DataSourceFactory {
    DataSource createDataSource();
}
