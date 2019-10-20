package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import com.github.lazyf1sh.sandbox.persistence.entities.Book2Entity;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.util.HibernatePersistenceUtil;

/**
 * JPA @GeneratedValue examples
 */
public class BasicExampleJpaGeneratedValue
{
    @Test
    public void run()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();
        entityManager.getTransaction().begin();

        Book2Entity book2Entity = new Book2Entity();
        book2Entity.setName("Harry Potter");
        entityManager.persist(book2Entity);

        entityManager.getTransaction().commit();
    }
}
