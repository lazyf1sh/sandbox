package com.github.lazyf1sh.sandbox.java.dozermapper.conf;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author Ivan Kopylov
 */
public class DozerMapper
{
    private static final DozerBeanMapper instance;
    static
    {
        instance = new DozerBeanMapper();
        instance.addMapping(new MapperConfiguration());
    }

    public static Mapper getInstance()
    {
        return instance;
    }
}
