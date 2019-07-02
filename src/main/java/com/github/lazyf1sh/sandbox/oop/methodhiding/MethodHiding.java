package com.github.lazyf1sh.sandbox.oop.methodhiding;

public class MethodHiding
{
    public static class Child extends Base
    {
        public void myMethod()
        {
            System.out.println("Child");
        }
    }

    public static class Base
    {
        public void myMethod()
        {
            System.out.println("Base");
        }
    }

    public static void main(String[] args)
    {
        ((Base)new Child()).myMethod();
    }
}
