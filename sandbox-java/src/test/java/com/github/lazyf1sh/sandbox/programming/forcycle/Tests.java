package com.github.lazyf1sh.sandbox.programming.forcycle;

import org.junit.Test;

public class Tests
{
    @Test
    public void run1()
    {
        System.out.println("Cycle one");
        CyclesIncrementAndPrint.cycleOne(0, 2);
        System.out.println("---");
        System.out.println("Cycle two");
        CyclesIncrementAndPrint.cycleTwo(0, 2);
        System.out.println("---");
        System.out.println("Cycle two option 2");
        CyclesIncrementAndPrint.cycleTwoOption2(0, 2);
        System.out.println("---");
        System.out.println("Cycle three");
        CyclesIncrementAndPrint.cycleThree(0, 2);
        System.out.println("---");
        System.out.println("Cycle four");
        CyclesIncrementAndPrint.cycleFour(0, 2);
        System.out.println("---");
        System.out.println("Cycle five");
        CyclesIncrementAndPrint.cycleFive(0, 2);
    }
}
