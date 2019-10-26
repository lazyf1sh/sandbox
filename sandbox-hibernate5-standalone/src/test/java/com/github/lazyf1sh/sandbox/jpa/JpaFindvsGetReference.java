package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.hibernate.proxy.HibernateProxy;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Difference between EntityManager#find and EntityManager#getReference
 */
public class JpaFindvsGetReference
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

    /**
     * proxy, that provides lazy access, throws an error on access
     * getReference can be considered the lazy version of find
     * The object content is retrieved from the database and the persistent fields are initialized, lazily, when the entity object is first accessed.
     */
    @Test
    public void getReference()
    {
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();

        ParentEntity parent = entityManger.getReference(ParentEntity.class, 999999999); //no db hit, parent is proxy

        assertEquals(999999999, parent.getId());//no init
        assertTrue(parent.getClass().toString().contains("$HibernateProxy$"));
        assertTrue(parent instanceof HibernateProxy);

        entityManger.close();
    }

    @Test(expected = EntityNotFoundException.class)
    public void getReferenceException()
    {
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();

        ParentEntity parent = entityManger.getReference(ParentEntity.class, 999999999); //no db hit

        assertEquals(999999999, parent.getId());//no init
        assertTrue(parent.getClass().toString().contains("$HibernateProxy$"));
        assertTrue(parent instanceof HibernateProxy);
        parent.getName(); //produces exception

        entityManger.close();
    }

}
