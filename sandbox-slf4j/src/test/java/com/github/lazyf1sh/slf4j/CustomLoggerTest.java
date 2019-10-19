package com.github.lazyf1sh.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CustomLoggerTest
{
    @Test
    public void run()
    {
        Logger logger = LoggerFactory.getLogger("myLogger");
        logger.info("My custom message");

    }
}