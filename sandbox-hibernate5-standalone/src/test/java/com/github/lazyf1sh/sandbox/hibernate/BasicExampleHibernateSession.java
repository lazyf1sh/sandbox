package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * Minimal example with Hibernate session - save and load saved entity
 */
public class BasicExampleHibernateSession
{
    @Test
    public void run()
    {
        Session session = HibernateSessionFactory.getSession();
        session.getTransaction().begin();

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);
        session.persist(bookEntity);

        session.getTransaction().commit();

        BookEntity entity = session.find(BookEntity.class, 0);
        Assert.assertEquals(entity.getName(), "Harry Potter");
        session.close();
    }
}
