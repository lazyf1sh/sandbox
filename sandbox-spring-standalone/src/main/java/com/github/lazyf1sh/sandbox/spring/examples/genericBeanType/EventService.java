package com.github.lazyf1sh.sandbox.spring.examples.genericBeanType;

import org.springframework.stereotype.Service;

/**
 * @author Ivan Kopylov
 */
@Service
public class EventService implements GenericService<Event>
{
    @Override
    public void genericMethod()
    {
        System.out.println("EventService called.");
    }
}
