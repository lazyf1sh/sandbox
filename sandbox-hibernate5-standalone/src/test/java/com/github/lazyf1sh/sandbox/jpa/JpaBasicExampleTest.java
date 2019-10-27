package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Minimal JPA example - save and load saved entity
 */
public class JpaBasicExampleTest
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Terry Pratchett - The Colour of Magic");
        bookEntity.setId(6);
        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();

        BookEntity entity = entityManager.find(BookEntity.class, 6);
        Assert.assertEquals(entity.getName(), "Terry Pratchett - The Colour of Magic");
        entityManager.close();
    }
}
