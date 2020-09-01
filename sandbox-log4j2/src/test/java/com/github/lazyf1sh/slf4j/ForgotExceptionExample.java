package com.github.lazyf1sh.slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ForgotExceptionExample
{
    private static final Logger LOGGER = LogManager.getLogger("myLogger");

    @Test
    public void incorrect()
    {
        try
        {
            new SomeService().veryComplexLogic();
        }
        catch (Exception e)
        {
            LOGGER.error("Now I spent ages to find NPE root cause");
        }
    }


    @Test
    public void correct()
    {

        try
        {
            new SomeService().veryComplexLogic();
        }
        catch (Exception e)
        {
            LOGGER.error("I can quickly find root cause", e);
        }
    }


}
