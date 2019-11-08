package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Ivan Kopylov
 */
@Entity
public class AddressEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int    id;
    private String street;
    private int    houseNumber;
    private String city;
    private int          zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity person;

    public int getId()
    {
        return id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(final int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(final int zipCode)
    {
        this.zipCode = zipCode;
    }

    public PersonEntity getPerson()
    {
        return person;
    }

    public void setPerson(final PersonEntity person)
    {
        this.person = person;
    }
}