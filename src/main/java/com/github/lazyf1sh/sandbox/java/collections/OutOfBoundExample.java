package com.github.lazyf1sh.sandbox.java.collections;

import java.util.ArrayList;
import java.util.List;

public class OutOfBoundExample
{
    public static void main(String[] args)
    {
        List l = new ArrayList<>();
        l.get(-1);
        int i = 0;
    }
}
