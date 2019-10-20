package com.github.lazyf1sh.sandbox.headers;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Headers
{
    public static void main(String[] args) throws Exception
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);

        ProducerTemplate template = camelContext.createProducerTemplate();
        camelContext.start();
        template.sendBodyAndHeader("direct:myHeadersTest", "myBodyValue", "myHeaderKey", "myHeaderValue");
    }
}
