package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DocumentService
{
    @Autowired
    private DocumentLoader documentLoader;

    public String runLogic()
    {
        documentLoader.load("");
        return "succes";
    }
}
