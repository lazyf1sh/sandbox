package com.github.lazyf1sh.sandbox.java.jcl.java.util.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * bifunctional [baɪ'feckʃ(ə)nəl]
 *
 * @author Ivan Kopylov
 */
public class BiFunctionExample
{
    private static final String VALUE     = "MY_VALUE";
    private static final int    INT_VALUE = 1;

    @Test
    public void run()
    {
        BiFunction<String, Integer, List<String>> sqlListener = new BiFunction<String, Integer, List<String>>()
        {
            @Override
            public List<String> apply(final String myValue, final Integer myInt)
            {
                System.out.println("SQL: " + myValue);
                System.out.println("SQL: " + myInt);

                List<String> list = new ArrayList<String>();

                list.add(VALUE);
                list.add(myInt.toString());
                return list;
            }
        };

        List<String> result = sqlListener.apply(VALUE, INT_VALUE);
        assertEquals(VALUE, result.get(0));
        assertEquals(String.valueOf(INT_VALUE), result.get(1));
    }
}
