package com.github.lazyf1sh.sandbox.spring.config.annotations.components.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyService
{
    public void run()
    {
        System.out.println("hello");
    }
}
