package com.slievrly.seata.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */
@Configuration
public class SeataConfig {

    @Value("${seata.txServiceGroup}")
    private String txServiceGroup;

    @Bean
    public GlobalTransactionScanner getGlobalTransactionScanner() {
        return new GlobalTransactionScanner("performance", txServiceGroup);
    }
}
