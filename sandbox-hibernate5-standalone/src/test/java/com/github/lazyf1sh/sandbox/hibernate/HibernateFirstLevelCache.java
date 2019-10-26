package com.github.lazyf1sh.sandbox.hibernate;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 1. First level cache cannot be turned off<br/>
 * 2.
 */
public class HibernateFirstLevelCache
{
    @BeforeClass
    public static void populate()
    {
        BookEntity book = new BookEntity();
        book.setId(0);
        book.setName("The Lord of the Rings");

        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void no_db_hit()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 0);

        assertEquals(book.getName(), "The Lord of the Rings");

        book = session.load(BookEntity.class, 0);

        assertEquals(book.getName(), "The Lord of the Rings");

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void evict()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 0);

        assertEquals(book.getName(), "The Lord of the Rings");
        session.evict(book);

        book = session.load(BookEntity.class, 0);
        assertEquals(book.getName(), "The Lord of the Rings");

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void clear()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 0);

        assertEquals(book.getName(), "The Lord of the Rings");
        session.clear();

        book = session.load(BookEntity.class, 0);
        assertEquals(book.getName(), "The Lord of the Rings");

        session.getTransaction().commit();
        session.close();
    }


}
