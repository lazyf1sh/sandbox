package com.github.lazyf1sh.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ClassnameLoggerTest
{
    @Test
    public void run()
    {
        Logger logger = LoggerFactory.getLogger(ClassnameLoggerTest.class);
        logger.info("classname logger");

    }
}