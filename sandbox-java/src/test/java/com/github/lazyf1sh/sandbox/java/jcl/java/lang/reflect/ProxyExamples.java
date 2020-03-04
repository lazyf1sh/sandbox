package com.github.lazyf1sh.sandbox.java.jcl.java.lang.reflect;

import java.lang.reflect.Proxy;
import java.util.Map;

import org.junit.Test;

public class ProxyExamples
{
    @Test
    public void run()
    {
        Map<String, String> proxyInstance = (Map<String, String>) Proxy.newProxyInstance(
                ProxyExamples.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler());

        proxyInstance.put("hello", "world");
    }
}
