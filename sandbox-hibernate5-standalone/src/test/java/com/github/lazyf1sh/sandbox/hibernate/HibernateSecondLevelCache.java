package com.github.lazyf1sh.sandbox.hibernate;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class HibernateSecondLevelCache
{
    @BeforeClass
    public static void populate()
    {
        BookEntity book = new BookEntity();
        book.setId(0);
        book.setName("The Lord of the Rings");

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        session.save(book);
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void a()
    {
        Session session1 = HibernateSessionFactory.openSession();
//        Session session2 = HibernateSessionFactory.openSession();
        session1.clear();
//        session2.clear();


        session1.getTransaction().begin();
//        session2.getTransaction().begin();

        BookEntity book = session1.get(BookEntity.class, 0);
        assertEquals(book.getName(), "The Lord of the Rings");



        session1.getTransaction().commit();
//        session2.getTransaction().commit();
        session1.close();
//        session2.close();
    }


}
