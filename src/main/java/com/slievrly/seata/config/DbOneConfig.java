package com.slievrly.seata.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */
@ConfigurationProperties(prefix = "spring.datasource.database-one")
public class DbOneConfig {
    private String jdbcUrl;

    private String username;

    private String password;

    private String driverClassName;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
