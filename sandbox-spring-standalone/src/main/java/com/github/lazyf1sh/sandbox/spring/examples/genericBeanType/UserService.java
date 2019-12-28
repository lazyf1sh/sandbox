package com.github.lazyf1sh.sandbox.spring.examples.genericBeanType;

import sun.net.www.content.text.Generic;

import org.springframework.stereotype.Service;

/**
 * @author Ivan Kopylov
 */
@Service
public class UserService implements GenericService<User>
{
    @Override
    public void genericMethod()
    {
        System.out.println("UserService called.");
    }
}
