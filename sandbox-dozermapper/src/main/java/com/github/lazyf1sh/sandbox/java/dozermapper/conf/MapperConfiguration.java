package com.github.lazyf1sh.sandbox.java.dozermapper.conf;

import org.dozer.loader.api.BeanMappingBuilder;

import com.github.lazyf1sh.sandbox.java.dozermapper.objects.A;
import com.github.lazyf1sh.sandbox.java.dozermapper.objects.B;
import com.github.lazyf1sh.sandbox.java.dozermapper.objects.C;
import com.github.lazyf1sh.sandbox.java.dozermapper.objects.D;
import com.github.lazyf1sh.sandbox.java.dozermapper.objects.E;

/**
 * @author Ivan Kopylov
 */
public class MapperConfiguration extends BeanMappingBuilder
{
    @Override
    protected void configure()
    {
        mapping(A.class, C.class).fields("key", "key");
        mapping(B.class, C.class).fields("key_a", "objA.key");
        mapping(E.class, D.class);
    }
}
