package com.github.lazyf1sh.sandbox.java.mechanics.generics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * The term "unchecked" refers to the fact that the compiler and the runtime system do not have enough type information to perform all type checks that would be necessary to ensure type safety.
 * In this sense, certain operations are "unchecked".
 *
 */
public class UncheckedGenericWarningExample
{
    @Test
    public void main()
    {
        List list = new ArrayList();
        list.add("String"); // unchecked warning
        list.add(1); // unchecked warning
    }
}
