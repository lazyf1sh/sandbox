package com.github.lazyf1sh.sandbox.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MyClass
{
    private final MyService service;

    public MyClass(final MyService service)
    {
        this.service = service;
    }

    public void someMethod()
    {
        service.myMethod();
    }
}
