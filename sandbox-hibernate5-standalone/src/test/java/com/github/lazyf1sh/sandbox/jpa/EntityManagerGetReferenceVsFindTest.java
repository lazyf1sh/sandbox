package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernatePersistenceUtil;

import static org.junit.Assert.*;

/**
 * Purpose of this example: to show difference between EntityManager#find and EntityManager#getReference
 * Level of understanding: basic
 * Complexity: low
 */
public class EntityManagerGetReferenceVsFindTest
{
    @Test
    public void test()
    {
        EntityManager em1 = HibernatePersistenceUtil.getEntityManger();
        EntityManager em2 = HibernatePersistenceUtil.getEntityManger();

        // not a proxy with no lazy access;
        // if the object is not found in the database null is returned
        ParentEntity parentEntityObject = em1.find(ParentEntity.class, 1);

        // proxy, that provides lazy access, throws an error on access
        // getReference can be considered the lazy version of find
        // The object content is retrieved from the database and the persistent fields are initialized, lazily, when the entity object is first accessed.
        ParentEntity parentEntityProxy = em2.getReference(ParentEntity.class, 100);

        assertTrue(parentEntityProxy.getClass().toString().contains("_$$_jvst"));
        assertFalse(parentEntityObject.getClass().toString().contains("_$$_jvst"));
    }
}
