package com.github.lazyf1sh.sandbox.hibernate;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateDirtyChecking
{
    @Test
    public void dirtyChecking()
    {
        triggerDirtyCheck();
        verifyDirtyCheckWorks();
    }

    public void triggerDirtyCheck()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = session.find(BookEntity.class, 0);
        if (book != null)
        {
            book.setName("Fred Brooks - The Mythical Man-Month");
            //session.update(book);//Even though you comment this line still
            // hibernate triggers update query if book name is different
            //in the database this feature is called dirty checking in hibernate
        }

        session.getTransaction().commit();
        session.close();
    }

    public static void verifyDirtyCheckWorks()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = session.find(BookEntity.class, 0);
        if (book != null)
        {
            Assert.assertEquals("Fred Brooks - The Mythical Man-Month", book.getName());
        }

        session.getTransaction().commit();
        session.close();
    }


    @BeforeClass
    public static void populate()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        BookEntity book = new BookEntity();
        book.setName("Maxim Dorofeev - Inbox Zero");
        book.setId(0);

        session.persist(book);

        session.getTransaction().commit();
        session.close();
    }


}
