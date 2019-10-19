package com.github.lazyf1sh.slf4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CustomLoggerTest
{
    private static final Logger LOGGER = Logger.getLogger("myLogger");

    @Test
    public void main()
    {
        LOGGER.info("My custom message");
    }
}