package com.github.lazyf1sh.sandbox.persistence.jpa.orderby;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.util.List;

@Entity
public class Building
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

    @ElementCollection
    @OrderBy
    private List<String> phoneNumbers;

    public List<String> getPhoneNumbers()
    {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers)
    {
        this.phoneNumbers = phoneNumbers;
    }
}
