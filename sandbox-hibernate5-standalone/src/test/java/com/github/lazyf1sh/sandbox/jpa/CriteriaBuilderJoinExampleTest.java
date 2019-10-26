package com.github.lazyf1sh.sandbox.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * This example demonstrates minimal join boilerplate
 *
 * @author Ivan Kopylov
 */
public class CriteriaBuilderJoinExampleTest
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cq = cb.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cq.from(ParentEntity.class);

        root.join("childs");
        cq.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cq);
        List<ParentEntity> result = query.getResultList();

        for (ParentEntity parentEntity : result)
        {
            System.out.println(parentEntity.getName());
        }
    }
}
