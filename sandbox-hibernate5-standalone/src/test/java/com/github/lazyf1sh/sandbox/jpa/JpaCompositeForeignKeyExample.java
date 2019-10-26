package com.github.lazyf1sh.sandbox.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.DocumentEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.UserEntity;
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
        entityManager.close();
    }

    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        UserEntity user = new UserEntity();
        user.setCity("Moscow");
        user.setName("bob");
        user.setSsn(99999999);

        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setKey(0);
        documentEntity.setUser(user);

        entityManager.persist(user);
        entityManager.persist(documentEntity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
