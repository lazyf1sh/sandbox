package com.github.lazyf1sh.sandbox.gun.right.hand.javaIsAlwaysPassByValue;

abstract class AbstractContainer
{
    private Dog dog;

    AbstractContainer(Dog dog)
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

    abstract void myMethod();
}
