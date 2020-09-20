package com.github.lazyf1sh.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.domain.CompoundObject;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationBuildingDetails;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationGeneralDetails;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * @author Ivan Kopylov
 */
public class JpaCompoundSelectionConstruction
{
    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = HibernateSessionFactory.openSession();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails organizationBuildingDetails = new OrganizationBuildingDetails();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails generalDetails = new OrganizationGeneralDetails();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity organzation = new OrganizationEntity();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    /**
     * CompoundSelection filled according construct order.
     */
    @Test(expected = IllegalArgumentException.class)
    public void run_incorrect()
    {
        EntityManager entityManager = HibernateSessionFactory.openSession();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompoundObject> query = builder.createQuery(CompoundObject.class);
        Root<OrganizationEntity> cgedRoot = query.from(OrganizationEntity.class);

        CompoundSelection<CompoundObject> compoundSelection = builder.construct(CompoundObject.class, cgedRoot.get("organizationBuildingDetails").get("address"), cgedRoot.get("key")); //incorrect order
        query.select(compoundSelection);
        List<CompoundObject> resultList = entityManager.createQuery(query).getResultList();
    }

    /**
     * CompoundSelection filled according construct order.
     */
    @Test
    public void run_correct()
    {
        EntityManager entityManager = HibernateSessionFactory.openSession();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompoundObject> query = builder.createQuery(CompoundObject.class);
        Root<OrganizationEntity> cgedRoot = query.from(OrganizationEntity.class);

        CompoundSelection<CompoundObject> compoundSelection = builder.construct(CompoundObject.class, cgedRoot.get("key"), cgedRoot.get("organizationBuildingDetails").get("address")); //correct order
        query.select(compoundSelection);
        List<CompoundObject> resultList = entityManager.createQuery(query).getResultList();
        Assert.assertEquals(0, resultList.get(0).getA());
        Assert.assertEquals("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035", resultList.get(0).getB());
    }



}
