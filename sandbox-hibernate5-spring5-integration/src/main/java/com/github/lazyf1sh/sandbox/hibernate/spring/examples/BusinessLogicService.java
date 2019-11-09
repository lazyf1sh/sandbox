package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.github.lazyf1sh.sandbox.hibernate.spring.entities.ParentEntity;

/**
 * Business logic container.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BusinessLogicService
{
    @Autowired
    private DocumentLoader documentLoader;

    public String runLogic(String name)
    {
        List<ParentEntity> parents = documentLoader.load(name);
        return parents.stream().map(ParentEntity::getName).collect(Collectors.joining(", "));
    }
}
