package com.github.lazyf1sh.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger("myLogger");
        logger.trace("My custom message");
    }
}
