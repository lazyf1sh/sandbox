package com.github.lazyf1sh.sandbox.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A
{
    @Test
    public void run() throws InterruptedException
    {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String[] allBeans = ctx.getBeanDefinitionNames();
		MyClass my = (MyClass) ctx.getBean(MyClass.class);
		my.someMethod();

		Thread.sleep(2000);

		MyClass2 my2 = (MyClass2) ctx.getBean(MyClass2.class);
		my2.customMethod();
		my2 = (MyClass2) ctx.getBean(MyClass2.class);
		my2.customMethod();
    }
}
