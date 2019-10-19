package com.github.lazyf1sh.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicExample
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(BasicExample.class);
        logger.trace("Hello World");
    }
}
