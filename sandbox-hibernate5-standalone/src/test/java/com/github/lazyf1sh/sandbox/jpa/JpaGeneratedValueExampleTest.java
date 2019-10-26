package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import com.github.lazyf1sh.sandbox.persistence.entities.Book2Entity;

import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * JPA @GeneratedValue examples
 */
public class JpaGeneratedValueExampleTest
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        Book2Entity book1 = new Book2Entity();
        book1.setName("Harry Potter");

        Book2Entity book2 = new Book2Entity();
        book1.setName("The Lord of the Rings");

        entityManager.persist(book1);
        entityManager.persist(book2);

        entityManager.getTransaction().commit();
    }
}
