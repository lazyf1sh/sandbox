package com.github.lazyf1sh.sandbox.jpa;

import com.github.lazyf1sh.sandbox.persistence.entities.ChildEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.ParentEntity;
import com.github.lazyf1sh.sandbox.persistence.util.HibernatePersistenceUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class NPlusOneBehaviour
{
    /**
     * No additional queries without proxy's getter call
     */
    @Test
    public void run()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cr = cb.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cr.from(ParentEntity.class);
        cr.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cr);
        List<ParentEntity> parents = query.getResultList();

        for(ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
        }
    }


    /**
     * N+1 additional queries when accessing child proxy
     */
    @Test
    public void run2()
    {
        EntityManager entityManager = HibernatePersistenceUtil.getEntityManger();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> cr = cb.createQuery(ParentEntity.class);
        Root<ParentEntity> root = cr.from(ParentEntity.class);
        cr.select(root);

        TypedQuery<ParentEntity> query = entityManager.createQuery(cr);
        List<ParentEntity> parents = query.getResultList();

        for(ParentEntity parent : parents)
        {
            Set<ChildEntity> childs = parent.getChilds();
            for(ChildEntity childEntity : childs)
            {

            }
        }
    }
}
