package com.github.lazyf1sh.sandbox.java.jcl.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler
{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("Hi there");
        return "hello world";
    }
}
