package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * Minimal example with Hibernate session - save and load saved entity<br/>
 * Example available at: https://github.com/lazyf1sh/sandbox-java
 */
public class HibernateBasicExampleTest
{
    @Test
    public void run()
    {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(bookEntity);
        session.getTransaction().commit();
        session.close();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        BookEntity entity = session.find(BookEntity.class, 0);
        Assert.assertEquals(entity.getName(), "Harry Potter");
        session.getTransaction().commit();
        session.close();
    }
}
