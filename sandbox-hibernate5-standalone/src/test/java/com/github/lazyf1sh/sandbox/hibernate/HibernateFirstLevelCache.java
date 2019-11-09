package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

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
        book.setId(4);
        book.setName("Stephen King - Shining");

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void no_db_hit()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 4);

        assertEquals(book.getName(), "Stephen King - Shining");

        book = session.load(BookEntity.class, 4);

        assertEquals(book.getName(), "Stephen King - Shining");

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void evict()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 4);

        assertEquals(book.getName(), "Stephen King - Shining");
        session.evict(book);

        book = session.load(BookEntity.class, 4);
        assertEquals(book.getName(), "Stephen King - Shining");

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void clear()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity book = session.load(BookEntity.class, 4);

        assertEquals(book.getName(), "Stephen King - Shining");
        session.clear();

        book = session.load(BookEntity.class, 4);
        assertEquals(book.getName(), "Stephen King - Shining");

        session.getTransaction().commit();
        session.close();
    }


}
