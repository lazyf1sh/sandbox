package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LayeredStructureExample
{
    @Test
    public void run()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DocumentService documentService = context.getBean(DocumentService.class);
        Assert.assertEquals("success", documentService.runLogic());
    }
}
