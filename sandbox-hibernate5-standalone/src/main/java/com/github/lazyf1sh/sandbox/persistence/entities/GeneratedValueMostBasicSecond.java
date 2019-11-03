package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * drop sequence if exists MyGeneratorName
 */
@Entity
public class GeneratedValueMostBasicSecond
{
    @Id
    @GeneratedValue
    private long key;

    public long getKey()
    {
        return key;
    }
}
