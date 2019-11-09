package com.github.lazyf1sh.sandbox.persistence.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionFactory
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new Configuration().configure().buildSessionFactory(); //looks for hibernate.cfg.xml
        } catch (HibernateException e)
        {
            System.out.println("Hibernate session factory configuration failed " + e);
            throw new ExceptionInInitializerError();
        }
    }

    public static Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession()
    {
        return sessionFactory.openSession();
    }

    public static void close()
    {
        sessionFactory.close();
    }


    private HibernateSessionFactory()
    {
    }
}
