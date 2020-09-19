package com.github.lazyf1sh.sandbox.java.mechanics.oop.overriding.example1;

import java.util.HashMap;
import java.util.Map;

class Base
{
    public <T extends Number, Z extends Number> Map<T, Z> getMap(T t, Z z)
    {
        return new HashMap<T, Z>();
    }
}
