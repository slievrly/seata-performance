package com.slievrly.seata.controller;

import com.slievrly.seata.constant.Constants;
import com.slievrly.seata.service.basic.impl.InsertServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/11/07
 */
@RestController
@RequestMapping(value = "/perf/*")
public class PerformanceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceController.class);

    @Autowired
    private InsertServiceImpl insertService;

    @RequestMapping(value = "/seata/insert", method = RequestMethod.GET)
    public String seataDtxInsert() {
        try {
            insertService.seataPerformance();
        } catch (Exception exx) {

        }
        return Constants.SUCCESS_CODE;
    }

    @RequestMapping(value = "/nodtx/insert", method = RequestMethod.GET)
    public String noDtxInsert() {
        try {
            insertService.noDtxPerformance();
        } catch (Exception exx) {

            return Constants.FAIL_CODE;
        }
        return Constants.SUCCESS_CODE;

    }
}
