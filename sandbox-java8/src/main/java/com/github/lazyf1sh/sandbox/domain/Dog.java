package com.github.lazyf1sh.sandbox.domain;

/**
 * @author Ivan Kopylov
 */
public class Dog extends Animal
{
private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
