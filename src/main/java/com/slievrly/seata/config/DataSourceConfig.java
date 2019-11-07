package com.slievrly.seata.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */
@Configuration
@EnableConfigurationProperties({DbOneConfig.class, DbTwoConfig.class})
public class DataSourceConfig {

    @Autowired
    private DbOneConfig dbOneConfig;

    @Autowired
    private DbTwoConfig dbTwoConfig;

    @Primary
    @Bean(name = "dataSourceOne")
    public DataSource getDataSourceOne() {
        DruidDataSource dataSourceOne = new DruidDataSource();
        dataSourceOne.setUrl(dbOneConfig.getJdbcUrl());
        dataSourceOne.setDriverClassName(dbOneConfig.getDriverClassName());
        dataSourceOne.setUsername(dbOneConfig.getUsername());
        dataSourceOne.setPassword(dbOneConfig.getPassword());
        dataSourceOne.setKeepAlive(true);
        dataSourceOne.setMinIdle(5);
        dataSourceOne.setMaxActive(2000);
        return new DataSourceProxy(dataSourceOne);
    }

    @Bean(name = "dataSourceTwo")
    public DataSource getDataSourceTwo() {
        DruidDataSource dataSourceTwo = new DruidDataSource();
        dataSourceTwo.setUrl(dbTwoConfig.getJdbcUrl());
        dataSourceTwo.setDriverClassName(dbTwoConfig.getDriverClassName());
        dataSourceTwo.setUsername(dbTwoConfig.getUsername());
        dataSourceTwo.setPassword(dbTwoConfig.getPassword());
        dataSourceTwo.setKeepAlive(true);
        dataSourceTwo.setMinIdle(5);
        dataSourceTwo.setMaxActive(2000);
        return new DataSourceProxy(dataSourceTwo);
    }

    @Bean(name = "jdbcTemplateOne")
    public JdbcTemplate getJdbcTemplateOne(@Qualifier("dataSourceOne") DataSource dataSource) {
        JdbcTemplate jdbcTemplateOne = new JdbcTemplate(dataSource);
        return jdbcTemplateOne;
    }

    @Bean(name = "jdbcTemplateTwo")
    public JdbcTemplate getJdbcTemplateTwo(@Qualifier("dataSourceTwo") DataSource dataSource) {
        JdbcTemplate jdbcTemplateTwo = new JdbcTemplate(dataSource);
        return jdbcTemplateTwo;
    }

}
