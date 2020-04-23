package com.github.lazyf1sh.sandbox.java.jcl.util.function;

import java.util.function.Predicate;

/**
 * @author Ivan Kopylov
 */
public class PredicateCreator
{
    public static <T> Predicate<T> build(Predicate<T> predicate)
    {
        return value ->
        {
            if (predicate.test(value))
            {
                return true;
            }
            else
            {
                return false;
            }
        };
    }
}
