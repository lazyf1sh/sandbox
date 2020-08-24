package com.github.lazyf1sh.slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class CustomLoggerTest
{
    private static final Logger LOGGER = LogManager.getLogger("myLogger");

    @Test
    public void main()
    {
        LOGGER.info("My custom message");
    }
}