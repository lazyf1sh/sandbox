package com.github.lazyf1sh.persistence.jpa.fetchvsjoin;

import com.github.lazyf1sh.sandbox.persistence.jpa.fetchvsjoin.Gamer;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * In this two examples, JOIN query is used to load. They have certain difference.
 *
 * @author Ivan Kopylov
 */
public class FetchVsJoin
{
    /**
     * Join will not add information to the generated SQL query projection, so, no chance for hibernate to cache joined entity.
     */
    @Test
    public void join()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gamer> cq = builder.createQuery(Gamer.class);
        Root<Gamer> root = cq.from(Gamer.class);

        root.join("game");

        TypedQuery<Gamer> query = entityManager.createQuery(cq);
        query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Hibernate adds projections to joined table, so data is returned into Hibernate, so that Hibernate can cache this data.
     */
    @Test
    public void fetch()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gamer> cq = builder.createQuery(Gamer.class);
        Root<Gamer> root = cq.from(Gamer.class);

        root.fetch("game");

        TypedQuery<Gamer> query = entityManager.createQuery(cq);
        query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
