package com.github.lazyf1sh.sandbox.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextInitExampleMinimal
{
    @Test
    public void run()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-minimal.xml");
        context.getBeanDefinitionNames();

        Assert.assertEquals(1, context.getBeanDefinitionCount());
        Assert.assertEquals("com.github.lazyf1sh.sandbox.spring.MyBean#0", context.getBeanDefinitionNames()[0]);
    }
}
