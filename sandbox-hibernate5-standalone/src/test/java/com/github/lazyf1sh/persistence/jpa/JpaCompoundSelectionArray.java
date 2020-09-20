package com.github.lazyf1sh.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationBuildingDetails;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationGeneralDetails;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * @author Ivan Kopylov
 */
public class JpaCompoundSelectionArray
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

    @Test
    public void run_correct()
    {
        EntityManager entityManager = HibernateSessionFactory.openSession();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<OrganizationEntity> root = query.from(OrganizationEntity.class);

        CompoundSelection<Object[]> compoundSelection = builder.array(root.get("key"), root.get("organizationGeneralDetails").get("ogranizationalStructure"));

        query.select(compoundSelection);
        Object[] resultList = entityManager.createQuery(query).getSingleResult();
        Assert.assertNotNull(resultList[0]);
        Assert.assertEquals("Vertical", resultList[1]);
    }
}
