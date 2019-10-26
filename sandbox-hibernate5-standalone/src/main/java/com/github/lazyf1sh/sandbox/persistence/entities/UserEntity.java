package com.github.lazyf1sh.sandbox.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ivan Kopylov
 */
@Entity
@Table(name = "USER")
public class UserEntity implements Serializable
{
    @Id
    @Column(name = "USER_LOGIN")
    private String name;

    @Id
    @Column(name = "USER_SSN")
    private int ssn;

    @Column(name = "USER_CITY")
    private String city;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public int getSsn()
    {
        return ssn;
    }

    public void setSsn(final int ssn)
    {
        this.ssn = ssn;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }
}
