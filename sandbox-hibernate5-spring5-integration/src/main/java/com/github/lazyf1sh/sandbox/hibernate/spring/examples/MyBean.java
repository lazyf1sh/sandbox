package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MyBean
{
    public String getString()
    {
        return "myString";
    }
}
