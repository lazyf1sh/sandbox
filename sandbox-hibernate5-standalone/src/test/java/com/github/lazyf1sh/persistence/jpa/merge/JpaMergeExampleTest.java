package com.github.lazyf1sh.persistence.jpa.merge;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * Difference vs merge and persist
 */
public class JpaMergeExampleTest
{
    @Test
    public void merge_set_new_name_original_object()
    {
        ParentEntity initialEntity = new ParentEntity();
        initialEntity.setId(1);
        initialEntity.setName("initial name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        ParentEntity merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        initialEntity.setName("initial updated name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity reloadedEntity = entityManger.find(ParentEntity.class, 1);
        Assert.assertEquals("initial name", reloadedEntity.getName());
        Assert.assertEquals("initial name", merged.getName());
        Assert.assertEquals("initial updated name", initialEntity.getName());
        entityManger.close();
    }

    @Test
    public void merge_set_new_name_merged_object()
    {
        ParentEntity initialEntity = new ParentEntity();
        initialEntity.setId(2);
        initialEntity.setName("initial name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        ParentEntity merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        merged.setName("merged updated name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity reloadedEntity = entityManger.find(ParentEntity.class, 2);
        Assert.assertEquals("merged updated name", reloadedEntity.getName());
        Assert.assertEquals("merged updated name", merged.getName());
        Assert.assertEquals("initial name", initialEntity.getName());
        entityManger.close();
    }


    @Test
    public void persist_then_merge()
    {
        ParentEntity entity1 = new ParentEntity();
        entity1.setId(3);
        entity1.setName("entity 1");

        ParentEntity entity2 = new ParentEntity();
        entity2.setId(3);
        entity2.setName("entity 2");

        //save to db and commit
        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.persist(entity1);
        entityManger.getTransaction().commit();
        entityManger.close();

        //update detached entity with the same id
        entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.merge(entity2);
        entityManger.getTransaction().commit();
        entityManger.close();
    }


    @Test
    public void persist()
    {
        ParentEntity originalEntity = new ParentEntity();
        originalEntity.setId(4);
        originalEntity.setName("old parent name");

        EntityManager entityManger = JpaEntityManagerFactory.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.persist(originalEntity);//makes supplied entity managed

        originalEntity.setName("new parent name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = JpaEntityManagerFactory.getEntityManger();
        ParentEntity parentEntity1 = entityManger.find(ParentEntity.class, 4);
        Assert.assertEquals("new parent name", parentEntity1.getName());
        entityManger.close();
    }

}
