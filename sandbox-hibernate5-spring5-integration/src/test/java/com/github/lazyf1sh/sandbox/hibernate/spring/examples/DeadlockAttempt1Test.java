package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeadlockAttempt1Test
{
    @Test
    public void run()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean bean = context.getBean(MyBean.class);
        bean.getString();
    }
}
