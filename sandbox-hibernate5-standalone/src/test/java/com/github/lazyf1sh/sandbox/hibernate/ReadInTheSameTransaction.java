package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

public class ReadInTheSameTransaction
{
    @Test
    public void test_find()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(4);
        parentEntity.setName("test4");

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(parentEntity);
        session.getTransaction().commit();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        ParentEntity entity = session.get(ParentEntity.class, 4);
        entity.setName("test4-2");

        ParentEntity entity2 = session.find(ParentEntity.class, 4);
        Assert.assertEquals("message", "test4-2", entity2.getName());
        session.close();
    }

    @Test
    public void test_get()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(4);
        parentEntity.setName("test4");

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(parentEntity);
        session.getTransaction().commit();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        ParentEntity entity = session.get(ParentEntity.class, 4);
        entity.setName("test4-2");

        ParentEntity entity2 = session.get(ParentEntity.class, 4);
        Assert.assertEquals("message", "test4-2", entity2.getName());

    }

    @Test
    public void test_load()
    {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(4);
        parentEntity.setName("test4");

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(parentEntity);
        session.getTransaction().commit();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        ParentEntity entity = session.get(ParentEntity.class, 4);
        entity.setName("test4-2");

        ParentEntity entity2 = session.load(ParentEntity.class, 4);
        Assert.assertEquals("message", "test4-2", entity2.getName());
    }

}
