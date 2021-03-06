package com.github.lazyf1sh.sandbox.java.jcl.java.lang.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Map;

public class ProxyExamples
{
    @Test
    public void run()
    {
        Map<String, String> proxyInstance = (Map<String, String>) Proxy.newProxyInstance(
                ProxyExamples.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler());

        String put = proxyInstance.put("hello", "world");
        Assert.assertEquals("hello world", put);
    }
}
