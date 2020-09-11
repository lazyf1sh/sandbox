package com.github.lazyf1sh.sandbox.java.mechanics.serialversionuid;

import java.io.Serializable;

/**
 * The default implementation.
 *
 * @author Ivan Kopylov
 */
public class SerializableClass implements Serializable
{
    private              String value            = "123";
    private static final long   serialVersionUID = 3L;
    private static final long   qwe              = 3L;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
