package com.github.lazyf1sh.persistence.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Example of EntityManager#refresh.
 *
 * @author Ivan Kopylov
 */
public class JpaUpdateExampleTest
{
    @BeforeClass
    public static void prepareData()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(101);
        parentEntity.setName("Robert Patrick");

        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();
        entityManager.persist(parentEntity);
        entityManager.getTransaction().commit();
    }

    @Test
    public void run()
    {
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity parentEntity = entityManger.find(ParentEntity.class, 101);
        parentEntity.setName("Linda Hamilton");

        parentEntity = entityManger.find(ParentEntity.class, 101); //loads from persistence context first, then from database

        Assert.assertEquals("Linda Hamilton", parentEntity.getName());

        entityManger.refresh(parentEntity); //forces to update entity from database

        Assert.assertEquals("Robert Patrick", parentEntity.getName());
    }
}
