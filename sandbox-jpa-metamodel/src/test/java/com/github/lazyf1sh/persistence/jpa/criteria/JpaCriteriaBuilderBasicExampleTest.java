package com.github.lazyf1sh.persistence.jpa.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity_;
import com.github.lazyf1sh.sandbox.persistence.entities.SomeEntity;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

public class JpaCriteriaBuilderBasicExampleTest
{
    /**
     * Metamodel basic demonstration.
     */
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SomeEntity> cq = cb.createQuery(SomeEntity.class);
        Root<SomeEntity> root = cq.from(SomeEntity.class);
        cq.select(root);

        String name = ParentEntity_.NAME;//this is a target of this example

        Predicate namePredicate = cb.equal(root.get(name), "some name");
        cq.where(namePredicate);

        List<SomeEntity> result = entityManager.createQuery(cq).getResultList();

        for (SomeEntity someEntity : result)
        {
            System.out.println(someEntity.getName());
        }
    }

}
