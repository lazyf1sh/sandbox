package com.github.lazyf1sh.sandbox.oop.variablehiding;

public class VariableHiding
{
    private String message = "this is instance variable";

    VariableHiding() {
        String message = "constructor local variable";
        System.out.println(message);
    }

    public void printLocalVariable() {
        String message = "method local variable";
        System.out.println(message);
    }

    public void printInstanceVariable() {
        String message = "method local variable";
        System.out.println(this.message);
    }

    public static void main(String[] args)
    {
        new VariableHiding().printLocalVariable();
        new VariableHiding().printInstanceVariable();

    }
}

