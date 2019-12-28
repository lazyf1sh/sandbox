package com.github.lazyf1sh.sandbox.spring.examples.annotationService;

import org.springframework.stereotype.Service;

/**
 * No special behavior provided by this annotation - acts the same way as @Component. @Service is just a convention for programmers that all business logic inside class.
 *
 * @author Ivan Kopylov
 */
@Service
public class CarService
{
    public String getCar()
    {
        return "BMW";
    }
}
