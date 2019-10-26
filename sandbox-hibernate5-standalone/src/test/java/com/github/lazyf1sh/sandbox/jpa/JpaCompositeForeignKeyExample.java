package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.DocumentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * @author Ivan Kopylov
 */
public class JpaCompositeForeignKeyExample
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        DocumentEntity documentEntity = entityManager.find(DocumentEntity.class, 0);

        Assert.assertEquals(99999999, documentEntity.getUser().getSsn());
        Assert.assertEquals("bob", documentEntity.getUser().getName());

        entityManager.getTransaction().commit();
    }
}
