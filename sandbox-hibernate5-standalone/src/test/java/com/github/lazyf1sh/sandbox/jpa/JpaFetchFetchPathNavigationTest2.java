package com.github.lazyf1sh.sandbox.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.OrderEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.UserEntity;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * @author Ivan Kopylov
 * @see <a href="https://stackoverflow.com/questions/4511368/">https://stackoverflow.com/questions/4511368/</a>
 */
public class JpaFetchFetchPathNavigationTest2
{
    private static final String USER_NAME_ONE = "a";
    private static final String USER_NAME_TWO = "b";

    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        UserEntity user = new UserEntity();
        user.setName(USER_NAME_ONE);

        UserEntity user2 = new UserEntity();
        user2.setName(USER_NAME_TWO);

        OrderEntity order = new OrderEntity();
        order.setUser(user);

        OrderEntity order2 = new OrderEntity();
        order2.setUser(user2);

        entityManager.persist(user2);
        entityManager.persist(user);
        entityManager.persist(order);
        entityManager.persist(order2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void join_fetch_together()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> cq = builder.createQuery(OrderEntity.class);
        Root<OrderEntity> root = cq.from(OrderEntity.class);

        Join<OrderEntity, UserEntity> user = root.join("user");
        root.fetch("user"); //duplicated join will be generated, but the goal is achieved: projections are specified by hibernate in sql query

        Predicate name = builder.equal(user.get("name"), USER_NAME_ONE);
        cq.where(name);
        cq.select(root);

        TypedQuery<OrderEntity> query = entityManager.createQuery(cq);
        List<OrderEntity> result = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void cast_to_join()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> cq = builder.createQuery(OrderEntity.class);
        Root<OrderEntity> root = cq.from(OrderEntity.class);

        Join<OrderEntity, UserEntity> user = (Join) root.fetch("user");


        Predicate name = builder.equal(user.get("name"), USER_NAME_ONE);
        cq.where(name);
        cq.select(root);

        TypedQuery<OrderEntity> query = entityManager.createQuery(cq);
        List<OrderEntity> result = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
