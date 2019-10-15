package com.github.lazyf1sh.sandbox.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.Book2Entity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * Purpose: to demonstrate org.hibernate.Criteria simpliest example.
 *
 * @author Ivan Kopylov
 */
public class HibernateCriteriaExample
{
    @Test
    public void run()
    {
        Session session = HibernateSessionFactory.getSession();
        session.getTransaction().begin();

        Criteria criteria = session.createCriteria(Book2Entity.class);
        criteria.add(Restrictions.eq("name", "The Lord of the Rings"));
        List<Book2Entity> list = criteria.list();

        session.getTransaction().commit();

        Assert.assertTrue(list.size() > 0);
        Assert.assertEquals("The Lord of the Rings", list.get(0).getName());

    }
}
