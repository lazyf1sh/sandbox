package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Kopylov
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RestServiceEmulator
{
    @Autowired
    private BusinessLogicService businessLogicService;

    public String frontEndCallAcceptor(String name)
    {
        return businessLogicService.runLogic(name);
    }
}
