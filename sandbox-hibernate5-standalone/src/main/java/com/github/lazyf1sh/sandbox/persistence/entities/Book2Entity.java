package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK2")
public class Book2Entity
{
    @Id
    @GeneratedValue(generator = "book2seqgen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book2seqgen", sequenceName = "BOOK2_SEQ", allocationSize = 1)
    @Column(name = "BOOK2_KEY")
    private int key;

    public int getKey()
    {
        return key;
    }

    @Column(name = "BOOK2_NAME")
    private String name;

    public void setKey(int key) {
        this.key = key;
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
