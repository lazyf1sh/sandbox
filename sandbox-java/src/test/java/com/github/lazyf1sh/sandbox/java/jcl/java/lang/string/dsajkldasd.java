package com.github.lazyf1sh.sandbox.java.jcl.java.lang.string;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class dsajkldasd
{
    @Test
    public void test()
    {

        Stream.of(new MyObj("a"), new MyObj("b")).peek(o ->
        {
            if (true) o.setDasjlkdas("");
        }).collect(Collectors.toList());


        Stream.of(new MyObj("a"), new MyObj("b")).filter(obj ->
        {
            return true;
        }).collect(Collectors.toList());
    }

}
