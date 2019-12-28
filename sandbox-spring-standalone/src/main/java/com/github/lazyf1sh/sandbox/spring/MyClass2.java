package com.github.lazyf1sh.sandbox.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MyClass2
{
    @Lazy
    @Autowired
    private MyService service;

    public void customMethod()
    {
        service.myMethod();
    }
}
