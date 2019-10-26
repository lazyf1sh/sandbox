package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Minimal JPA example - save and load saved entity
 */
public class BasicExampleJpa
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);
        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();


        BookEntity entity = entityManager.find(BookEntity.class, 0);
        Assert.assertEquals(entity.getName(), "Harry Potter");
        entityManager.close();
    }
}
