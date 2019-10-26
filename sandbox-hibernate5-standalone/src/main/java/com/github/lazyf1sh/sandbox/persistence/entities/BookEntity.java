package com.github.lazyf1sh.sandbox.persistence.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@Cache(region = "personCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class BookEntity
{
    @Id
    @Column(name = "BOOK_KEY")
    private int id;

    @Column(name = "BOOK_NAME")
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }
}
