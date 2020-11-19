package com.github.lazyf1sh.sandbox.java.jcl.java.lang.functionalinterface;

/**
 * The default implementation of smth.
 *
 * @author Ivan Kopylov
 */
@FunctionalInterface
public interface LambdaInterface
{
    long doSomething(String str, int num);

    default int someDefaultMethod()
    {
        return 0;
    }
}
