package com.github.lazyf1sh.sandbox.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.lazyf1sh.sandbox.spring.MyBean;

public class SpringContextGetBeanExample
{
    @Test
    public void run()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-minimal.xml");
        context.getBeanDefinitionNames();

        MyBean bean = context.getBean(MyBean.class);
        Assert.assertEquals("my custom string", bean.getString());
    }
}
