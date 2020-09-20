package com.github.lazyf1sh.persistence.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.persistence.entities.Car;
import com.github.lazyf1sh.sandbox.persistence.util.JpaEntityManagerFactory;

/**
 * JPA @GeneratedValue examples
 */
public class JpaGeneratedValueExampleTest
{
    @Test
    public void run()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction().begin();

        Car car1 = new Car();
        car1.setName("ZAZ Zaporozhets");

        Car car2 = new Car();
        car2.setName("Unimog");

        Car car3 = new Car();
        car3.setName("Honda");

        Assert.assertEquals(0, car1.getKey());
        Assert.assertEquals(0, car2.getKey());
        Assert.assertEquals(0, car3.getKey());

        entityManager.persist(car1);
        entityManager.persist(car2);
        entityManager.persist(car3);

        Assert.assertEquals(1, car1.getKey());
        Assert.assertEquals(2, car2.getKey());
        Assert.assertEquals(3, car3.getKey());

        entityManager.getTransaction().commit();
    }
}
