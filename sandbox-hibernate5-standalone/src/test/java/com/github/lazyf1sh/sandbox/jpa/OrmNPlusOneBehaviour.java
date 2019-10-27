package com.github.lazyf1sh.sandbox.jpa;

import com.github.lazyf1sh.sandbox.persistence.entities.ChildEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * ORM N+1 problem demonstration
 */
public class OrmNPlusOneBehaviour
{
    @BeforeClass
    public static void populate()
    {
        Random random = new Random();

        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        for (int i = 7; i < 12; i++)
        {
            ParentEntity parent = new ParentEntity();
            parent.setId(i);
            parent.setName(String.valueOf(random.nextInt(99999)));

            ChildEntity child = new ChildEntity();
            child.setKey(i);
            child.setName(String.valueOf(random.nextInt(99999)));
            child.setParent(parent);

            entityManager.persist(parent);
            entityManager.persist(child);

        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    /**
     * No additional queries without proxy's getter call
     */
    @Test
    public void no_db_hits()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cr = cb.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cr.from(ParentEntity.class);
        cr.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cr);
        List<ParentEntity> parents = query.getResultList();

        for (ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
        }

        entityManager.close();
    }

    /**
     * N+1 additional queries when accessing db through child proxy
     */
    @Test
    public void n_plus_one()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cr = cb.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cr.from(ParentEntity.class);
        cr.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cr);
        List<ParentEntity> parents = query.getResultList();

        for (ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
            for (ChildEntity childEntity : childs)
            {
                childEntity.getName();//each call is db hit
            }
        }

        entityManager.close();
    }

    @Test
    public void solution_fetch()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cq = builder.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cq.from(ParentEntity.class);

        root.fetch("childs");
        cq.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cq);
        List<ParentEntity> parents = query.getResultList();

        entityManager.close();

        for (ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
            for (ChildEntity childEntity : childs)
            {
                Assert.assertNotNull(childEntity.getName());
            }
        }
    }

    @Test
    public void no_solution_join()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cq = builder.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cq.from(ParentEntity.class);

        root.join("childs");
        cq.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cq);
        List<ParentEntity> parents = query.getResultList();

        entityManager.close();

        System.out.println("---- FINISHED -----");

        for (ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
            for (ChildEntity childEntity : childs)
            {
                Assert.assertNotNull(childEntity.getName());
            }
        }
    }

}
