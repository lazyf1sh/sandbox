package com.github.lazyf1sh.sandbox.java.mechanics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericPitfalls
{
    @Test
    public void extends1()
    {

        List<? extends Number> list2 = new ArrayList<>();
        //it would seem that Integer, Double, ..., but no.
//        list.add(1L); // cannot be compiled
//        list.add(1); // cannot be compiled
        list2.add(null); //only null is possible
    }

    @Test
    public void super1()
    {
        List<? super Number> list = new ArrayList<>();
        list.add(1);
        list.add(1L);
//        list.add(new Object()); // cannot be compiled
    }

    @Test
    public void wild()
    {
        List<?> list = new ArrayList<>();
        list.add(null);
//        list.add(1L); // cannot be compiled
//        list.add(1); // cannot be compiled
//        list.add(""); // cannot be compiled
    }

    @Test
    public void dasd()
    {
        Number[] numbers = new Integer[10];
        numbers[1] = 1;


    }


}
