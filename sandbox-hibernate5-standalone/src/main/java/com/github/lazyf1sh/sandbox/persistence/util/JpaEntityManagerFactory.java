package com.github.lazyf1sh.sandbox.persistence.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.hibernate.jpa.boot.spi.IntegratorProvider;

public final class JpaEntityManagerFactory
{
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private JpaEntityManagerFactory()
    {
    }

    private static EntityManagerFactory buildEntityManagerFactory()
    {
        /*
          When Persistence.createEntityManagerFactory() is called,
          the persistence implementation will search your classpath for any META-INF/persistence.xml files
          using the ClassLoader.getResource("META-INF/persistence.xml") method

          https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html_single/#setup-configuration-bootstrapping
         */
        Map<String, Object> configuration = new HashMap<>();

        Integrator integrator = MetadataExtractorIntegrator.INSTANCE;
        if (integrator != null) {
            configuration.put("hibernate.integrator_provider",
                    (IntegratorProvider) () -> Collections.singletonList(
                            MetadataExtractorIntegrator.INSTANCE
                    )
            );
        }

        return Persistence.createEntityManagerFactory("my-persistence-unit", configuration);
    }

    public static EntityManager getEntityManger()
    {
        return emf.createEntityManager();
    }

    /**
     * drops the database when hbm2ddl = create-drop
     */
    public static void closeFactory()
    {
        emf.close();
    }

}
