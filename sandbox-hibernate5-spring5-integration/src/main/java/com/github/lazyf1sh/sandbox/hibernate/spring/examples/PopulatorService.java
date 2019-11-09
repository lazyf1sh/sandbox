package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.github.lazyf1sh.sandbox.hibernate.spring.entities.ParentEntity;

/**
 * @author Ivan Kopylov
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PopulatorService
{
    @PersistenceContext
    private EntityManager entityManager;

    public void populate()
    {
        ParentEntity parentEntity1 = new ParentEntity();
        parentEntity1.setId(1000);
        parentEntity1.setName("Alexander");

        ParentEntity parentEntity2 = new ParentEntity();
        parentEntity2.setId(1001);
        parentEntity2.setName("John");

        ParentEntity parentEntity3 = new ParentEntity();
        parentEntity3.setId(1002);
        parentEntity3.setName("Alexey");

        entityManager.persist(parentEntity1);
        entityManager.persist(parentEntity2);
        entityManager.persist(parentEntity3);
    }
}
