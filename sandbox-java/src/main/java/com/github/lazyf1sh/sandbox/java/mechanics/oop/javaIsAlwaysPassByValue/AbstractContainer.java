package com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue;

public abstract class AbstractContainer
{
    private Dog dog;

    public AbstractContainer(Dog dog)
    {
        this.dog = dog;
        myMethod();
    }

    public Dog getDog()
    {
        return dog;
    }

    public void setDog(final Dog dog)
    {
        this.dog = dog;
    }

    public abstract void myMethod();
}
