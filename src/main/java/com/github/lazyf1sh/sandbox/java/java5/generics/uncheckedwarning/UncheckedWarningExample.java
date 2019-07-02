package com.github.lazyf1sh.sandbox.java.java5.generics.uncheckedwarning;

import java.util.ArrayList;
import java.util.List;

/**
 * The term "unchecked" refers to the fact that the compiler and the runtime system do not have enough type information to perform all type checks that would be necessary to ensure type safety.
 * In this sense, certain operations are "unchecked".
 *
 */
public class UncheckedWarningExample
{
    public static void main(String[] args)
    {
        List list = new ArrayList();
        list.add("String"); // unchecked warning
    }
}
