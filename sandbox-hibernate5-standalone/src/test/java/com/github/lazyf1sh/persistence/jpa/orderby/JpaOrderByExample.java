package com.github.lazyf1sh.persistence.jpa.orderby;

import com.github.lazyf1sh.sandbox.persistence.jpa.orderby.Building;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class JpaOrderByExample
{
    @BeforeClass
    public static void populate()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        Building building = new Building();
        building.setKey(0);
        building.setPhoneNumbers(Arrays.asList("11", "7", "5", "10", "8", "4", "2", "3", "1", "9", "6"));

        entityManager.persist(building);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        Building building = entityManager.find(Building.class, 0L);
        List<String> phoneNumbers = building.getPhoneNumbers();

        Assert.assertEquals("1", phoneNumbers.get(0));
        Assert.assertEquals("10", phoneNumbers.get(1));
        Assert.assertEquals("11", phoneNumbers.get(2));
        Assert.assertEquals("2", phoneNumbers.get(3));
        Assert.assertEquals("3", phoneNumbers.get(4));
        Assert.assertEquals("4", phoneNumbers.get(5));
        Assert.assertEquals("5", phoneNumbers.get(6));
        Assert.assertEquals("6", phoneNumbers.get(7));
        Assert.assertEquals("7", phoneNumbers.get(8));
        Assert.assertEquals("8", phoneNumbers.get(9));
        Assert.assertEquals("9", phoneNumbers.get(10));

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
