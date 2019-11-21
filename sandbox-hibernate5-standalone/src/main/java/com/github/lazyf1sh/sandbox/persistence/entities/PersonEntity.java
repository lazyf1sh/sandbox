package com.github.lazyf1sh.sandbox.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PersonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int                 id;
    private String              name;
    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public List<AddressEntity> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(final List<AddressEntity> addresses)
    {
        this.addresses = addresses;
    }
}
