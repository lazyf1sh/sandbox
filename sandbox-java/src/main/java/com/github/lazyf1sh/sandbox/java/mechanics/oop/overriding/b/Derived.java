package com.github.lazyf1sh.sandbox.java.mechanics.oop.overriding.b;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Derived extends Base
{
    public <T, Z> TreeMap<T, Z> getMap(T t, Z z)
    {
        return new TreeMap<T, Z>();
    }

//    public Map<Number, Number> getMap(Number t, Number z)
//    {
//        return new TreeMap<Number, Number>();
//    }

    public Map<Integer, Integer> getMap(Number t, Number z)
    {
        return new HashMap<Integer, Integer>();
    }
}