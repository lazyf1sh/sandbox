package com.github.lazyf1sh.sandbox.sonarLintInspections;

import java.util.ArrayList;
import java.util.List;

public class A
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        boolean a = list.size() > 0;
        boolean b = !list.isEmpty();
        System.out.println(a);
        System.out.println(b);
    }
}
