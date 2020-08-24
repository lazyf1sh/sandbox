package com.github.lazyf1sh.slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ClassnameLoggerTest
{
    private static final Logger LOGGER = LogManager.getLogger(ClassnameLoggerTest.class);

    @Test
    public void main()
    {
        LOGGER.info("classname logger");
    }
}