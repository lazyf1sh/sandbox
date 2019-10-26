package com.github.lazyf1sh.sandbox.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManagerFactory
{
    private static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory()
    {
        /*
          When Persistence.createEntityManagerFactory() is called,
          the persistence implementation will search your classpath for any META-INF/persistence.xml files
          using the ClassLoader.getResource("META-INF/persistence.xml") method

          https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html_single/#setup-configuration-bootstrapping
         */
        return Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public static EntityManager getEntityManger()
    {
        return emf.createEntityManager();
    }

    /**
     * drops the database when hbm2ddl = create-drop
     */
    public void closeFactory()
    {
        emf.close();
    }

}
