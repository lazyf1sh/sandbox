package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.hibernate.proxy.HibernateProxy;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

import static org.junit.Assert.*;

/**
 * Difference between EntityManager#find and EntityManager#getReference
 */
public class EntityManagerGetReferenceVsFindTest
{
    @BeforeClass
    public static void populate()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(0);
        parentEntity.setName("some parent name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.persist(parentEntity);
        entityManger.getTransaction().commit();
        entityManger.close();
    }

    @Test
    public void find_method()
    {
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();

        // not a proxy with no lazy access;
        // if the object is not found in the database null is returned
        ParentEntity parentEntityObject = entityManger.find(ParentEntity.class, 0);

        assertFalse(parentEntityObject.getClass().toString().contains("_$$_jvst"));
        entityManger.close();
    }

    @Test
    public void getReference()
    {
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();

        // proxy, that provides lazy access, throws an error on access
        // getReference can be considered the lazy version of find
        // The object content is retrieved from the database and the persistent fields are initialized, lazily, when the entity object is first accessed.
        ParentEntity parentEntityProxy = entityManger.getReference(ParentEntity.class, 999999999);

        assertTrue(parentEntityProxy.getClass().toString().contains("$HibernateProxy$"));
        assertTrue(parentEntityProxy instanceof HibernateProxy);
        entityManger.close();
    }



}
