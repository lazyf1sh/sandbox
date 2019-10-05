package com.github.lazyf1sh;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service(value = "someService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SomeService
{
    @Cacheable(value = "cacheName", key = "#arg")
    public String getValue(String arg)
    {
        return arg;
    }
}
