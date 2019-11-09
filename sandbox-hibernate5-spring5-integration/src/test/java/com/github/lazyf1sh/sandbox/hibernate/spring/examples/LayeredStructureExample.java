package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LayeredStructureExample
{
    private static ApplicationContext context;

    @Test
    public void run()
    {
        RestServiceEmulator documentService = context.getBean(RestServiceEmulator.class);
        Assert.assertEquals("Alexander, Alexey", documentService.frontEndCallAcceptor("Alex"));
    }

    @BeforeClass
    public static void populate()
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PopulatorService populator = context.getBean(PopulatorService.class);
        populator.populate();
    }
}
