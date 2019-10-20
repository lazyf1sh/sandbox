package com.github.lazyf1sh.sandbox.hibernate;

import org.hibernate.Session;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntityWithEmbedded;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

public class EmbeddedEntityTest
{
    @Test
    public void dsad()
    {
        Session session = HibernateSessionFactory.getSession();

        ParentEntityWithEmbedded entity = session.load(ParentEntityWithEmbedded.class, 4);

        entity.getMyEmbeddable().getName();
        session.close();
    }
}
