package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.Book2Entity;
import com.github.lazyf1sh.sandbox.persistence.entities.Page2Entity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernatePersistenceUtil;

/**
 *
 */
public class EntityOutOfTransaction
{
    private int pageId;

    @Before
    public void populate()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();
        entityManager.getTransaction().begin();

        Book2Entity book2Entity = new Book2Entity();
        book2Entity.setName("The Lord of the Rings");

        Page2Entity page2Entity = new Page2Entity();
        page2Entity.setAnnotations("1. Annotation; 2. Annotation");
        page2Entity.setName("");
        page2Entity.setBook2Entity(book2Entity);

        entityManager.persist(book2Entity);
        entityManager.persist(page2Entity);

        pageId = page2Entity.getKey();

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Test
    public void normalBehaviour()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();
        entityManager.getTransaction().begin();

        Page2Entity page2Entity = entityManager.find(Page2Entity.class, pageId);
        if (page2Entity != null)
        {
            Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page2Entity.getAnnotations());
            Assert.assertEquals("asserts book name equality", page2Entity.getName(), "");
        } else
        {
            Assert.fail();
        }

        entityManager.getTransaction().commit();
    }

    @Test(expected = LazyInitializationException.class)
    public void outOfTransactionNoFkNoGetter()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();
        entityManager.getTransaction().begin();

        Page2Entity page2Entity = entityManager.find(Page2Entity.class, pageId);
        if (page2Entity != null)
        {
            Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page2Entity.getAnnotations());
            Assert.assertEquals("asserts book name equality", page2Entity.getName(), "");


            entityManager.getTransaction().commit();
            entityManager.close();

            page2Entity.getBook2Entity();
        } else
        {
            Assert.fail();
        }
    }

    @Test
    public void outOfTransactionNoFkGet()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();
        entityManager.getTransaction().begin();

        Page2Entity page2Entity = entityManager.find(Page2Entity.class, pageId);
        if (page2Entity != null)
        {
            entityManager.getTransaction().commit();
            entityManager.close();

            Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page2Entity.getAnnotations());
            Assert.assertEquals("asserts book name equality", page2Entity.getName(), "");

            Book2Entity book2Entity = page2Entity.getBook2Entity();
            String name = book2Entity.getName();
            System.out.println(name);
        } else
        {
            Assert.fail();
        }
    }

}
