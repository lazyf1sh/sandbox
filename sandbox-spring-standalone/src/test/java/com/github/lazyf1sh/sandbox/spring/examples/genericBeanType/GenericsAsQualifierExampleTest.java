package com.github.lazyf1sh.sandbox.spring.examples.genericBeanType;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ivan Kopylov
 */
public class GenericsAsQualifierExampleTest
{
    @Test
    public void run()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        GenericsAsQualifierExample runnerService = ctx.getBean(GenericsAsQualifierExample.class);
        runnerService.run();
    }
}