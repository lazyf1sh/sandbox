package com.github.lazyf1sh.slf4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ClassnameLoggerTest
{
    private static final Logger LOGGER = Logger.getLogger(ClassnameLoggerTest.class);

    @Test
    public void main()
    {
        LOGGER.info("classname logger");
    }
}