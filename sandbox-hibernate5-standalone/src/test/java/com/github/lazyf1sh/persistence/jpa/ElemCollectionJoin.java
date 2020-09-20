package com.github.lazyf1sh.persistence.jpa;

import com.github.lazyf1sh.sandbox.persistence.entities.a.Ticket;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class ElemCollectionJoin
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cr = cb.createQuery(Ticket.class);
        Root<Ticket> root = cr.from(Ticket.class);
        cr.select(root);

        Join<Object, Object> objectObjectObjectMapJoin = root
                .join("ticketDetails")
                .join("genericProperties")
                .join("properties");

        TypedQuery<Ticket> query = entityManager.createQuery(cr);
        List<Ticket> parents = query.getResultList();

        if (parents.size() > 0)
        {
            parents.get(0).getTicketDetails().getGenericProperties().getProperties();
        }
    }

}
