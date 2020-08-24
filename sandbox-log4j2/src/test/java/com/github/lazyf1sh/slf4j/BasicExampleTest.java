package com.github.lazyf1sh.slf4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class BasicExampleTest
{

    private static final Logger LOGGER = LogManager.getLogger(BasicExampleTest.class);
    @Test
    public void main()
    {
        LOGGER.trace("Hello World");
    }
}