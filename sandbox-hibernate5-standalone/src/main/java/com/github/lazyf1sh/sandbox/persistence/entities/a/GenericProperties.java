package com.github.lazyf1sh.sandbox.persistence.entities.a;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

/**
 * @author Ivan Kopylov
 */
@Embeddable
public class GenericProperties
{
    @ElementCollection(fetch = FetchType.LAZY, targetClass = PropertyValue.class)
    @CollectionTable(name = "PROPERTIES", joinColumns = @JoinColumn(name = "PROPERTIES_KEY"))
    private Map<String, PropertyValue> properties;

    public Map<String, PropertyValue> getProperties()
    {
        return properties;
    }

    public void setProperties(final Map<String, PropertyValue> properties)
    {
        this.properties = properties;
    }
}
