package com.example.demo.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这个类就是 aspect
 */
public class AdderAfterReturnAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void afterReturn(Object returnValue) {
        logger.info("\n --------- The value was {} -------------", returnValue);
    }
}
