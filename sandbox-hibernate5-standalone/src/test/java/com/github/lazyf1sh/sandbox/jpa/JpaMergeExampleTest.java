package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Difference vs merge and persist
 */
public class JpaMerge
{

    @Test
    public void merge()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(1);
        parentEntity.setName("old parent name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.merge(parentEntity);//copies the state from the supplied entity, and makes the new copy managed.

        parentEntity.setName("new parent name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity parentEntity1 = entityManger.find(ParentEntity.class, 1);
        Assert.assertEquals("old parent name", parentEntity1.getName());
        entityManger.close();
    }

    @Test
    public void persist()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(1);
        parentEntity.setName("old parent name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.persist(parentEntity);//makes supplied entity managed

        parentEntity.setName("new parent name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity parentEntity1 = entityManger.find(ParentEntity.class, 1);
        Assert.assertEquals("new parent name", parentEntity1.getName());
        entityManger.close();
    }

}
