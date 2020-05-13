package com.github.lazyf1sh.sandbox.java.dozermapper.conf;

import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2.From;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2.To;
import org.dozer.loader.api.BeanMappingBuilder;

import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.A;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.B;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.C;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.D;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.E;
import org.dozer.loader.api.TypeMappingOptions;

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

        mapping(From.class, To.class, TypeMappingOptions.wildcard(Boolean.FALSE))
        .fields("inner", "receiver");
    }
}
