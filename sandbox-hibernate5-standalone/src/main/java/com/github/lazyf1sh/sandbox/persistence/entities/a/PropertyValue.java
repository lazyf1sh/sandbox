package com.github.lazyf1sh.sandbox.persistence.entities.a;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ivan Kopylov
 */
@Embeddable
public class PropertyValue
{
    @Column(name = "PROPERTIES_VALUE")
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(final String value)
    {
        this.value = value;
    }
}
