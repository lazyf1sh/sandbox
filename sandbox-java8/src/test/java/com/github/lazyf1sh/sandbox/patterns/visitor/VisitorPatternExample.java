package com.github.lazyf1sh.sandbox.patterns.visitor;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Visitor_pattern
 *
 * @author Ivan Kopylov
 */
public class VisitorPatternExample
{
    @Test
    public void main()
    {
        Car car = new Car();

        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }

}

interface CarElement
{
    void accept(CarElementVisitor visitor);
}

interface CarElementVisitor
{
    void visit(Body body);

    void visit(Car car);

    void visit(Engine engine);

    void visit(Wheel wheel);
}

class Wheel implements CarElement
{
    private final String name;

    public Wheel(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void accept(CarElementVisitor visitor)
    {
        /*
         * accept(CarElementVisitor) in Wheel implements
         * accept(CarElementVisitor) in CarElement, so the call
         * to accept is bound at run time. This can be considered
         * the *first* dispatch. However, the decision to call
         * visit(Wheel) (as opposed to visit(A) etc.) can be
         * made during compile time since 'this' is known at compile
         * time to be a Wheel. Moreover, each implementation of
         * CarElementVisitor implements the visit(Wheel), which is
         * another decision that is made at run time. This can be
         * considered the *second* dispatch.
         */
        visitor.visit(this);
    }
}

class Body implements CarElement
{
    @Override
    public void accept(CarElementVisitor visitor)
    {
        visitor.visit(this);
    }
}

class Engine implements CarElement
{
    @Override
    public void accept(CarElementVisitor visitor)
    {
        visitor.visit(this);
    }
}

class Car implements CarElement
{
    private final List<CarElement> elements;

    public Car()
    {
        this.elements = Arrays.asList(
                new Wheel("front left"), new Wheel("front right"),
                new Wheel("back left"), new Wheel("back right"),
                new Body(), new Engine()
        );
    }

    @Override
    public void accept(CarElementVisitor visitor)
    {
        for (CarElement element : elements)
        {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

class CarElementDoVisitor implements CarElementVisitor
{
    @Override
    public void visit(Body body)
    {
        System.out.println("Moving my body");
    }

    @Override
    public void visit(Car car)
    {
        System.out.println("Starting my car");
    }

    @Override
    public void visit(Wheel wheel)
    {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine engine)
    {
        System.out.println("Starting my engine");
    }
}

class CarElementPrintVisitor implements CarElementVisitor
{
    @Override
    public void visit(Body body)
    {
        System.out.println("Visiting body");
    }

    @Override
    public void visit(Car car)
    {
        System.out.println("Visiting car");
    }

    @Override
    public void visit(Engine engine)
    {
        System.out.println("Visiting engine");
    }

    @Override
    public void visit(Wheel wheel)
    {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
}


