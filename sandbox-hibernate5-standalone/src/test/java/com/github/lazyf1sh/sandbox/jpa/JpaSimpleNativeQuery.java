package com.github.lazyf1sh.sandbox.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.junit.Before;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Minimal JPA example - save and load saved entity.
 */
public class JpaSimpleNativeQuery
{
    @Before
    public void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(5001);
        bookEntity.setName("some name");

        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();


        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM BOOK;");

        List<Tuple> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
