package com.github.lazyf1sh.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class HibernateSecondLevelCache
{
    @BeforeClass
    public static void populate()
    {

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        NativeQuery sqlQuery = session.createSQLQuery("INSERT INTO BOOK VALUES (5, 'Tolkien - The Hobbit')");
        int i = sqlQuery.executeUpdate();
        assertEquals(1, i);
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void run()
    {
        Session session1 = HibernateSessionFactory.openSession();
        Session session2 = HibernateSessionFactory.openSession();
        session1.getTransaction().begin();
        session2.getTransaction().begin();

        BookEntity book = session1.load(BookEntity.class, 5);
        assertEquals(book.getName(), "Tolkien - The Hobbit");

        book = session2.load(BookEntity.class, 5);
        assertEquals(book.getName(), "Tolkien - The Hobbit");

        session1.getTransaction().commit();
        session2.getTransaction().commit();
        session1.close();
        session2.close();
    }


}
