package com.github.lazyf1sh.sandbox.java.dozermapper;

import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.dozermapper.conf.DozerMapper;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.A;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.B;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.C;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.D;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case1.E;


public class ObjectMapperExample
{

    @Test
    public void main()
    {
        Mapper mapper = DozerMapper.getInstance();
        A objA = new A();
        objA.setKey("1");

        C result = mapper.map(objA, C.class);
        Assert.assertEquals("1", result.getKey());
    }

    @Test
    public void two()
    {
        Mapper mapper = DozerMapper.getInstance();
        C c = new C();
        c.setKey("1");

        A result = mapper.map(c, A.class);
        Assert.assertEquals("1", result.getKey());
    }

    @Test
    public void tdasdsawo()
    {
        Mapper mapper = DozerMapper.getInstance();
        A a = new A();
        a.setKey("2");
        C c = new C();
        c.setObjA(a);

        B result = mapper.map(c, B.class);
        Assert.assertEquals("2", result.getKey_a());
    }

    @Test
    public void tdasddsawo()
    {
        Mapper mapper = DozerMapper.getInstance();
        B input = new B();
        input.setKey_a("3");

        C output = mapper.map(input, C.class);
        Assert.assertEquals("3", output.getObjA().getKey());
    }

    @Test
    public void no_setters()
    {
        Mapper mapper = DozerMapper.getInstance();

        D input = new D();

        E output = mapper.map(input, E.class);

        Assert.assertNotNull(output);
        Assert.assertNull(output.getKey());
    }
}