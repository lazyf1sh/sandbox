package com.github.lazyf1sh.sandbox.spring.examples.annotationService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Kopylov
 */
public class CarServiceTest
{
    @Test
    public void run()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarService carService = ctx.getBean(CarService.class);
        String car = carService.getCar();
        assertEquals("BMW", car);
    }
}