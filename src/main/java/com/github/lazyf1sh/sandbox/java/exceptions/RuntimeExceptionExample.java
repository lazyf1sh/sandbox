package com.github.lazyf1sh.sandbox.java.exceptions;

public class RuntimeExceptionExample
{
    public static void main(String[] args)
    {
        System.out.println("1");
        throwException();
        System.out.println("2");
    }

    private static void throwRuntime()
    {
        throw new RuntimeException("my exception");
    }

    private static void throwException()
    {
        //throw new Exception("my exception");
    }
}
