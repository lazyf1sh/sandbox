package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ivan Kopylov
 */
@Embeddable
public class OrganizationBuildingDetails
{
    @Column(name = "WORKPLACES")
    private int    workplaces;
    @Column(name = "FLOORS")
    private int    floors;
    @Column(name = "ADDRESS")
    private String address;

    public int getWorkplaces()
    {
        return workplaces;
    }

    public void setWorkplaces(final int workplaces)
    {
        this.workplaces = workplaces;
    }

    public int getFloors()
    {
        return floors;
    }

    public void setFloors(final int floors)
    {
        this.floors = floors;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }
}
