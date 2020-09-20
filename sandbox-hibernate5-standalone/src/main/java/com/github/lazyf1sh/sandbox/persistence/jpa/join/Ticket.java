package com.github.lazyf1sh.sandbox.persistence.jpa.join;

import com.github.lazyf1sh.sandbox.persistence.entities.a.TicketDetails;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ivan Kopylov
 */
@Entity
public class Ticket
{
    @Id
    @Column(name = "TICKET_ID", unique = true, nullable = false)
    private int key;

    @Column(name = "TICKET_DESCRIPTION")
    private String name;

    @Embedded
    private TicketDetails ticketDetails;

    public int getKey()
    {
        return key;
    }

    public void setKey(final int key)
    {
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

    public TicketDetails getTicketDetails()
    {
        return ticketDetails;
    }

    public void setTicketDetails(final TicketDetails ticketDetails)
    {
        this.ticketDetails = ticketDetails;
    }
}
