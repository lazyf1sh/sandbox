package com.github.lazyf1sh.sandbox.persistence.jpa.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "IDENTITY_EXAMPLE")
public class IdentityExampleEntity
{
    /**
     * The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view.
     * <p>
     * It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.
     */
    @Id
    @Column(name = "IDENTITY_EXAMPLE_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId()
    {
        return id;
    }
}
