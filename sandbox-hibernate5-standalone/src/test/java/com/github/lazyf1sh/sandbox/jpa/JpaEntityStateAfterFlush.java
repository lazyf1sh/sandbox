package com.github.lazyf1sh.sandbox.jpa;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;

public class JpaEntityStateAfterFlush
{
    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        ParentEntity parent = new ParentEntity();
        parent.setName("0");
        parent.setId(3000);

        entityManager.persist(parent);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void run()
    {
        do_flush();
        read_again();
    }

    public void do_flush()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        ParentEntity parent = entityManager.find(ParentEntity.class, 3000);
        parent.setName("1");

        entityManager.flush(); //hits db

        parent.setName("2");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void read_again()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        ParentEntity parent = entityManager.find(ParentEntity.class, 3000);

        Assert.assertEquals("2", parent.getName());

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
