package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.hibernate.TransientPropertyValueException;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ChildEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * This example demonstrates exception when saving child before parent
 */
public class SaveChildBeforeParentTest
{
    @Test(expected = TransientPropertyValueException.class)
    public void saveChildBeforeParent()
    {
        Session session = HibernateSessionFactory.getCurrentSession();

        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(10);
        parentEntity.setName("123");

        ChildEntity childEntity = new ChildEntity();
        childEntity.setKey(10);
        childEntity.setName("123");
        childEntity.setParent(parentEntity);

        session.saveOrUpdate(childEntity);
        session.saveOrUpdate(parentEntity);
    }

}
