package com.github.lazyf1sh.sandbox.persistence.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class A implements Integrator
{

    public static final A INSTANCE = new A();

    private Database database;

    private Metadata metadata;

    public Database getDatabase() {
        return database;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry)
    {
        this.database = metadata.getDatabase();
        this.metadata = metadata;
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry)
    {

    }
}
