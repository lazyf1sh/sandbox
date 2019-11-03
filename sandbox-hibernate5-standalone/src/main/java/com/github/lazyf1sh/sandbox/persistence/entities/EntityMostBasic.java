package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * If no @Table and @Column are specified, Hibernate generates following schema:<br/>
 * create table MinimalEntity (key bigint not null, primary key (key))
 */
@Entity
public class EntityMostBasic
{
    @Id
    private long key;

    public long getKey()
    {
        return key;
    }

    public void setKey(long key)
    {
        this.key = key;
    }
}
