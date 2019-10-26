package com.github.lazyf1sh.sandbox.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.BookEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * org.hibernate.Criteria simpliest example.<br/>
 * Example available at: https://github.com/lazyf1sh/sandbox-java
 *
 * @author Ivan Kopylov
 */
public class HibernateCriteriaExample
{
    @Test
    public void run()
    {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.getTransaction().begin();

        Criteria criteria = session.createCriteria(BookEntity.class);
        criteria.add(Restrictions.eq("name", "The Lord of the Rings"));
        List<BookEntity> list = criteria.list();

        Assert.assertTrue(list.size() > 0);
        Assert.assertEquals("The Lord of the Rings", list.get(0).getName());

        session.getTransaction().commit();
        session.close();
    }

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
}
