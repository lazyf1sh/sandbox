package com.github.lazyf1sh.sandbox.hibernate.spring.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.github.lazyf1sh.sandbox.hibernate.spring.entities.ParentEntity;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class DocumentLoader
{
    @PersistenceContext
    private EntityManager entityManager;

    public List<ParentEntity> load(String name)
    {
//        boolean active = entityManager.getTransaction().isActive();
//        System.out.println(String.format("Transaction is active: %s", active));
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity> query = builder.createQuery(ParentEntity.class);
        Root<ParentEntity> root = query.from(ParentEntity.class);

        Predicate name_ = builder.like(root.get("name"), name + "%");

        query.select(root);
        query.where(name_);
        return entityManager.createQuery(query).getResultList();
    }
}
