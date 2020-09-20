package com.github.lazyf1sh.persistence.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationBuildingDetails;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationEntity;
import com.github.lazyf1sh.sandbox.persistence.entities.OrganizationGeneralDetails;
import com.github.lazyf1sh.sandbox.persistence.util.HibernateSessionFactory;

/**
 * @Embedded annotation demonstration.
 */
public class JpaEmbededAnnotationExampleTest
{
    @Test
    public void run()
    {
        EntityManager entityManager = HibernateSessionFactory.openSession();
        entityManager.getTransaction().begin();

        OrganizationEntity organization = entityManager.find(OrganizationEntity.class, 0);

        Assert.assertEquals(5, organization.getOrganizationBuildingDetails().getFloors());
        Assert.assertEquals("1997", organization.getOrganizationGeneralDetails().getFound());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

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
}
