package com.github.lazyf1sh.sandbox.java.mechanics.serialversionuid;

import java.io.Serializable;

/**
 *
 *
 * @author Ivan Kopylov
 */
public class SerializableClass implements Serializable
{
    private              String value            = "123";
    private static final long   serialVersionUID = 3L;

    public SerializableClass(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
