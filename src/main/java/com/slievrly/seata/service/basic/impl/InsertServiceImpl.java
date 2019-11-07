package com.slievrly.seata.service.basic.impl;

import com.slievrly.seata.constant.Constants;
import com.slievrly.seata.service.basic.AbstractPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */
@Service
public class InsertServiceImpl extends AbstractPerformanceService {

    private static final String INSERT_SQL = "insert into test(id,name) values(?,?)";

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Qualifier("jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplatetwo;

    @Override
    protected void doBussiness() {
        long id = System.nanoTime() - Constants.BASE_NANO_TIME;
        jdbcTemplateOne.update(INSERT_SQL, (preparedStatement) -> {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, "name1");
        });

        jdbcTemplatetwo.update(INSERT_SQL, (preparedStatement) -> {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, "name2");
        });
    }
}
