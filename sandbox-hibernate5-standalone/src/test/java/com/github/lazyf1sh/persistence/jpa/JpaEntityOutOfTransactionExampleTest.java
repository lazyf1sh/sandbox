package com.github.lazyf1sh.persistence.jpa;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.PageEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 *
 */
public class JpaEntityOutOfTransactionExampleTest
{
    private static int pageId;

    @Test
    public void normalBehaviour()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        PageEntity page = entityManager.find(PageEntity.class, pageId);
        Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
        Assert.assertEquals("asserts book name equality", page.getName(), "");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test(expected = LazyInitializationException.class)
    public void outOfTransactionNoFkNoGetter()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        PageEntity page = entityManager.find(PageEntity.class, pageId);

        Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
        Assert.assertEquals("asserts book name equality", page.getName(), "");

        entityManager.getTransaction().commit();
        entityManager.close();

        BookEntity book = page.getBook();
        String name = book.getName();
    }

    @Test
    public void outOfTransactionNoFkGet()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        PageEntity page = entityManager.find(PageEntity.class, pageId);

        entityManager.getTransaction().commit();
        entityManager.close();

        Assert.assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
        Assert.assertEquals("asserts book name equality", page.getName(), "");

        BookEntity book = page.getBook();
    }

    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        BookEntity book = new BookEntity();
        book.setId(7);
        book.setName("The Lord of the Rings");

        PageEntity page = new PageEntity();
        page.setAnnotations("1. Annotation; 2. Annotation");
        page.setName("");
        page.setBook(book);

        entityManager.persist(book);
        entityManager.persist(page);

        pageId = page.getKey();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
