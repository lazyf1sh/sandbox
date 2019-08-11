package com.github.lazyf1sh.sandbox.java.strings;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
