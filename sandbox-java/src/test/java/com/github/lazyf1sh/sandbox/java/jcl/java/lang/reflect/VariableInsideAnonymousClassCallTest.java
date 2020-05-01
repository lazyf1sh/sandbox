package com.github.lazyf1sh.sandbox.java.jcl.java.lang.reflect;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * How to call variable passed to an anonymous class
 *
 * @author Ivan Kopylov
 */
public class VariableInsideAnonymousClassCallTest
{
    @Test
    public void test()
    {
        B b = new B()
        {
            @Override
            public void targetMethodToCall()
            {
                assertTrue(true);
            }
        };

        A a = new A()
        {
            //b field is created implicitly

            public void myMethod()
            {
                b.targetMethodToCall();
            }
        };

        Field[] a_fields = a.getClass().getDeclaredFields();
        Stream.of(a_fields).filter(field -> B.class.isAssignableFrom(field.getType()))
                .forEach(field -> {
                    try
                    {
                        field.setAccessible(true);
                        ((B)field.get(a)).targetMethodToCall();
                    }
                    catch (Exception ex)
                    {
                        fail();
                    }
                });

    }

}