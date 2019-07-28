package com.github.lazyf1sh.sandbox.oop.methodhiding;

/**
 * @author Ivan Kopylov
 */
public class RunnerAB
{
    public static void main(String[] args)
    {
        ((B)new A()).test();
    }
}
