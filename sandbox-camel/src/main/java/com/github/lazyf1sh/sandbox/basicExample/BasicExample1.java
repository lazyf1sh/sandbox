package com.github.lazyf1sh.sandbox.basicExample;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicExample1
{
    public static void main(String[] args) throws Exception
    {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);

        ProducerTemplate template = camelContext.createProducerTemplate();
        camelContext.start();
        template.sendBody("direct:test123", "Hello World");
    }
}
