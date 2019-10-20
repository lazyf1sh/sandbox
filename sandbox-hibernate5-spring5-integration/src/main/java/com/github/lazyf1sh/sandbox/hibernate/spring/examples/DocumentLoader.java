package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public class DocumentLoader
{
    @PersistenceContext
    private EntityManager entityManager;

    public void load(String documentId)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //
    }
}
