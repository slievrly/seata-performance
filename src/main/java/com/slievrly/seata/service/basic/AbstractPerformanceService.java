package com.slievrly.seata.service.basic;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */

import io.seata.spring.annotation.GlobalTransactional;

public abstract class AbstractPerformanceService {

    @GlobalTransactional
    public void seataPerformance() {
        doBussiness();
    }

    public void noDtxPerformance() {
        doBussiness();
    }

    protected abstract void doBussiness();
}
