package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntityWithEmbedded;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

public class JpaEmbededAnnotationExampleTest
{
    @Test
    public void dsad()
    {
        EntityManager entityManager = HibernateSessionFactory.getSession();
        entityManager.getTransaction().begin();
        ParentEntityWithEmbedded entity = entityManager.find(ParentEntityWithEmbedded.class, 0);
        entity.getMyEmbeddable().getName();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @BeforeClass
    public static void populate()
    {
        ParentEntityWithEmbedded entityWithEmbedded = new ParentEntityWithEmbedded();
        entityWithEmbedded.setId(0);
    }
}
